package com.project;

import java.util.ArrayList;
import java.util.List;

import com.project.network.Network;
import com.project.util.Matrix;
import com.project.util.Tuple;

public class Main {
	static int[] sizes = { 2, 2, 1 };
	static List<Tuple<Matrix, Matrix>> trainingData = new ArrayList<>();
	static List<Tuple<Matrix, Matrix>> testData = new ArrayList<>();
	
	public static void main(String[] args) {

		trainingData.add(new Tuple<>(new Matrix(new double[][]{{0}, {0}}), new Matrix(new double[][]{{0}})));
        testData.add(new Tuple<>(new Matrix(new double[][]{{0}, {0}}), new Matrix(new double[][]{{0}})));

        trainingData.add(new Tuple<>(new Matrix(new double[][]{{0}, {1}}), new Matrix(new double[][]{{1}})));
        testData.add(new Tuple<>(new Matrix(new double[][]{{0}, {1}}), new Matrix(new double[][]{{1}})));

        trainingData.add(new Tuple<>(new Matrix(new double[][]{{1}, {0}}), new Matrix(new double[][]{{1}})));
        testData.add(new Tuple<>(new Matrix(new double[][]{{1}, {0}}), new Matrix(new double[][]{{1}})));

        trainingData.add(new Tuple<>(new Matrix(new double[][]{{1}, {1}}), new Matrix(new double[][]{{0}})));
        testData.add(new Tuple<>(new Matrix(new double[][]{{1}, {1}}), new Matrix(new double[][]{{0}})));

		Network nn = new Network(sizes);
		nn.StochasticGradientDescent(trainingData, 40, 10, 4, testData);
	}
}
