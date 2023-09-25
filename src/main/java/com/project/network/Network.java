package com.project.network;

import com.project.util.Matrix;
import com.project.util.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Class for building neural network
 * @author Luiz Guilherme Amadi Braga
 */
public class Network {

    private int numLayers;
    private int[] sizes;
    private List<Matrix> biases;
    private List<Matrix> weights;

    /** 
     * @param sizes
     * sizes is an array of integers in wich the i-th position is referring to the number of neurons in the i-th layer
     * For example, sizes = [5, 10, 6] is a 3-layered network with 5 neurons in the first layer, 10 in second and 6 in third
     */
    public Network(int[] sizes) {
        this.numLayers = sizes.length;
        this.sizes = sizes;
        this.biases = new ArrayList<>();
        this.weights = new ArrayList<>();

        // Initializes biases and weights matrices with gaussian-distributed random values
        for (int i = 1; i < sizes.length; i++) {
            this.biases.add(new Matrix(sizes[i], 1));
            this.weights.add(new Matrix(sizes[i], sizes[i - 1]));
        }
    }

    /**
     * Prints the network showing how many layers there are, and how many neurons in wich one of them
     */
    public void displayNetwork() {
        System.out.println("Layers:");
        for (int i = 0; i < this.numLayers; i++) {
            System.out.printf("Layer %d: %d neurons\n", i, this.sizes[i]);
        }
        System.out.println("\nWeights:");
        for (int i = 0; i < this.weights.size(); i++) {
            System.out.printf("Layer %d to %d:\n", i, i + 1);
            this.weights.get(i).displayMatrix();
        }
        System.out.println("Biases:");
        for (int i = 0; i < this.biases.size(); i++) {
            System.out.printf("Layer %d:\n", i + 1);
            this.biases.get(i).displayMatrix();
        }
    }
    
    /** 
     * Calculates the input of next layer of neurons
     * @param inputs
     * @return Matrix
     */
    public Matrix feedForward(Matrix inputs) {
        for (int i = 0; i < this.numLayers - 1; i++) {
            Matrix b = this.biases.get(i);
            Matrix w = this.weights.get(i);
            inputs = Matrix.sigmoid(Matrix.add(Matrix.multiply(w, inputs), b));
        }
        return inputs;
    }

    /** 
     * @param outputActivations
     * @param y
     * @return Matrix
     */
    public static Matrix costDerivative(Matrix outputActivations, Matrix y) {
        return Matrix.subtract(outputActivations, y);
    }
    
    /** 
     * Evaluates the network performance in guessing the correct bets to be made
     * Receives a testData of Tuples<inputsMatrix, expectedOutputMatrix> to perform its evaluation
     * @param testData
     * @return double
     */
    public double evaluate(List<Tuple<Matrix, Matrix>> testData) {
        int hits = 0;
        int misses = 0;
    
        for (Tuple<Matrix, Matrix> example : testData) {
            Matrix input = example.getX();
            Matrix trueResult = example.getY();
    
            Matrix output = this.feedForward(input);
            output = Matrix.round(output, 0.25);
            for (int i = 0; i < output.getRows(); i++) {
                for (int j = 0; j < output.getColumns(); j++) {
                    if (output.getData()[i][j] == 1.0 && trueResult.getData()[i][j] == 1.0) {
                        hits++;
                    }
                    if (output.getData()[i][j] == 1.0 && trueResult.getData()[i][j] == 0.0) {
                        misses++;
                    }
                }
            }
        }

        double percentageHit = (double)hits/(hits + misses);
        return percentageHit;
    }
    
    /** 
     * Computes the gradients (partial derivatives) of the cost function with respect to the weights and biases of a neural network
     * @param x
     * @param y
     * @return Tuple<List<Matrix>, List<Matrix>>
     */
    public Tuple<List<Matrix>, List<Matrix>> backprop(Matrix x, Matrix y) {
        List<Matrix> nablaB = new ArrayList<>();
        List<Matrix> nablaW = new ArrayList<>();
    
        for (Matrix b : this.biases) {
            nablaB.add(new Matrix(b.getRows(), b.getColumns()));
        }

        for (Matrix w : this.weights) {
            nablaW.add(new Matrix(w.getRows(), w.getColumns()));
        }

        Matrix activation = x;
        List<Matrix> activations = new ArrayList<>();
        activations.add(x);
        List<Matrix> zs = new ArrayList<>();
    
        for (int i = 0; i < this.biases.size(); i++) {
            Matrix b = this.biases.get(i);
            Matrix w = this.weights.get(i);
            
            Matrix z = Matrix.add(Matrix.multiply(w, activation), b);
            zs.add(z);
            
            activation = Matrix.sigmoid(z);
            activations.add(activation);
        }

        Matrix delta = Matrix.dot(costDerivative(activations.get(activations.size() - 1), y), Matrix.dsigmoid(zs.get(zs.size() - 1)));
    
        Matrix copyDeltaFirst = delta.copy();
        nablaB.set(nablaB.size() - 1, copyDeltaFirst);

        nablaW.set(nablaW.size() - 1, Matrix.multiply(delta, Matrix.transpose(activations.get(activations.size() - 2))));
    
        for (int l = 2; l < this.numLayers; l++) {
            Matrix z = zs.get(zs.size() - l);
            Matrix sp = Matrix.dsigmoid(z);
            delta = Matrix.dot(Matrix.multiply(Matrix.transpose(this.weights.get(weights.size() - l + 1)), delta), sp);

            Matrix copyDelta = delta.copy();
            nablaB.set(nablaB.size() - l, copyDelta);
            nablaW.set(nablaW.size() - l, Matrix.multiply(delta, Matrix.transpose(activations.get(activations.size() - l - 1))));
        }
        return new Tuple<>(nablaB, nablaW);
    }

    /** 
     * Updates the parameters in the opposite direction of the gradient of the cost function with respect to the network's parameters
     * Calls backpropagation to compute the gradient
     * @param miniBatch
     * @param eta
     */
    public void updateMiniBatch(List<Tuple<Matrix, Matrix>> miniBatch, double eta) {
        List<Matrix> nabla_b = new ArrayList<>();
        List<Matrix> nabla_w = new ArrayList<>();
        for (Matrix b : biases) {
            nabla_b.add(new Matrix(b.getRows(), b.getColumns(), true));
        }
        for (Matrix w : weights) {
            nabla_w.add(new Matrix(w.getRows(), w.getColumns(), true));
        }
    
        for (Tuple<Matrix, Matrix> tuple : miniBatch) {
            Matrix x = tuple.getX();
            Matrix y = tuple.getY();
            Tuple<List<Matrix>, List<Matrix>> deltas = backprop(x, y);
            List<Matrix> delta_nabla_b = deltas.getX();
            List<Matrix> delta_nabla_w = deltas.getY();
            for (int i = 0; i < nabla_b.size(); i++) {
                nabla_b.set(i, Matrix.add(nabla_b.get(i), delta_nabla_b.get(i)));
            }
            for (int i = 0; i < nabla_w.size(); i++) {
                nabla_w.set(i, Matrix.add(nabla_w.get(i), delta_nabla_w.get(i)));
            }
        }

        for (int i = 0; i < weights.size(); i++) {
            Matrix nw = Matrix.multiply(nabla_w.get(i), eta / miniBatch.size());
            weights.set(i, Matrix.subtract(weights.get(i), nw));
        }
        for (int i = 0; i < biases.size(); i++) {
            Matrix nb = Matrix.multiply(nabla_b.get(i), eta / miniBatch.size());
            biases.set(i, Matrix.subtract(biases.get(i), nb));
        }
    }

    /**
     * Randomly select a subset of training data (mini-batch) and calls a function to update network's parameters based in this subset
     * @param trainingData
     * @param epochs
     * @param miniBatchSize
     * @param eta
     * @param testData
     */
    public void StochasticGradientDescent(List<Tuple<Matrix, Matrix>> trainingData, int epochs, int miniBatchSize, double eta, List<Tuple<Matrix, Matrix>> testData) {
        int nTest = 0;
        if (testData != null) {
            nTest = testData.size();
        }
        int n = trainingData.size();
        
        for (int j = 0; j < epochs; j++) {
            Collections.shuffle(trainingData);

            List<List<Tuple<Matrix, Matrix>>> miniBatches = new ArrayList<>();
            for (int k = 0; k < n; k += miniBatchSize) {
                List<Tuple<Matrix, Matrix>> miniBatch = new ArrayList<>();
                for (int index = k; index < k + miniBatchSize && index < n; index++) {
                    miniBatch.add(trainingData.get(index));
                }
                miniBatches.add(miniBatch);
            }
            
            for (List<Tuple<Matrix, Matrix>> miniBatch : miniBatches) {
                updateMiniBatch(miniBatch, eta);
            }
            
            if (testData != null) {
                System.out.println("Epoch " + j + ": " + evaluate(testData) + " / " + nTest);
            } else {
                System.out.println("Epoch " + j + " complete");
            }
        }
    }
    
}
