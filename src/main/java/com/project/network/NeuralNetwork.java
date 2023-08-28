package com.project.network;

import java.util.List;

import com.project.util.Matrix;

public class NeuralNetwork {
    private Matrix wih, who, bh, bo;
    double learningRate = 0.01;
    
    public NeuralNetwork(int inputs, int hidden, int output) {
        this.wih = new Matrix(hidden, inputs);
        this.who = new Matrix(output, hidden);
        this.bh = new Matrix(hidden, 1);
        this.bo = new Matrix(output, 1);
    }

    public List<Double> predict(double[] x) {
        Matrix input = Matrix.fromArray(x);
        Matrix hidden = Matrix.multiply(this.wih, input);
        hidden.add(this.bh);
        hidden.sigmoid();

        Matrix output = Matrix.multiply(this.who, hidden);
        output.add(this.bo);
        output.sigmoid();

        return output.toArray();
    }

    public void fit(double[][] x, double[][] y, int epochs) {
        for(int i = 0; i < epochs; i++) {
            int sampleN = (int)(Math.random() * x.length);
            this.train(x[sampleN], y[sampleN]);
        }
    }

    public void train(double [] X,double [] Y) {
		Matrix input = Matrix.fromArray(X);
		Matrix hidden = Matrix.multiply(this.wih, input);
		hidden.add(this.bh);
		hidden.sigmoid();
		
		Matrix output = Matrix.multiply(this.who,hidden);
		output.add(this.bo);
		output.sigmoid();
		
		Matrix target = Matrix.fromArray(Y);
		
		Matrix error = Matrix.subtract(target, output);
		Matrix gradient = output.dsigmoid();
		gradient.multiply(error);
		gradient.multiply(this.learningRate);
		
		Matrix hidden_T = Matrix.transpose(hidden);
		Matrix who_delta =  Matrix.multiply(gradient, hidden_T);

		this.who.add(who_delta);
		this.bo.add(gradient);

		Matrix who_T = Matrix.transpose(this.who);
		Matrix hidden_errors = Matrix.multiply(who_T, error);
		
		Matrix h_gradient = hidden.dsigmoid();
		h_gradient.multiply(hidden_errors);
		h_gradient.multiply(this.learningRate);
		
		Matrix i_T = Matrix.transpose(input);
		Matrix wih_delta = Matrix.multiply(h_gradient, i_T);
		
		this.wih.add(wih_delta);
		this.bh.add(h_gradient);
	}
}
