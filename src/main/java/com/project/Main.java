package com.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.project.data.CollectData;
import com.project.data.ProcessData;
import com.project.network.Network;
import com.project.util.Matrix;
import com.project.util.Tuple;

import tech.tablesaw.api.Table;

public class Main {
	static int[] sizes = { 2, 2, 1 };
	static List<Tuple<Matrix, Matrix>> trainingData = new ArrayList<>();
	static List<Tuple<Matrix, Matrix>> testData = new ArrayList<>();
	
	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Table> tables = CollectData.generateTrainingAndTestData();

		sizes[0] = tables.get("trainingDataInput").columnCount() - 1;
		sizes[1] = 50;
		sizes[2] = tables.get("trainingDataOutput").columnCount() - 1;

		trainingData = ProcessData.generateTuple(tables.get("trainingDataInput"), tables.get("trainingDataOutput"));
		testData = ProcessData.generateTuple(tables.get("testingDataInput"), tables.get("testingDataOutput"));

		Network nn = new Network(sizes);
		nn.StochasticGradientDescent(trainingData, 30, 10, 0.4, testData);
	}
}
