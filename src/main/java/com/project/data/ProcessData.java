package com.project.data;

import com.project.util.Matrix;
import com.project.util.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

public class ProcessData {
    public static void main(String[] args) {
        HashMap<String, Table> hashMap = CollectData.generateTrainingAndTestData();

        // Only for testing data integrity
        // Use System.out.println(Arrays.deepToString(nameOfMatrix)) to display all data in form of matrix
        List<Tuple<Matrix, Matrix>> list = generateTuple(hashMap.get("trainingDataInput"), hashMap.get("trainingDataOutput"));
        list.get(0).getX().displayMatrix();
        list.get(0).getY().displayMatrix();
    }

    public static double[][] tableToArrayTransformer(Table table) {
        int numberOfColumns = table.columnCount() - 1;
        int numberOfRows = table.rowCount();

        double[][] matrix = new double[numberOfRows][numberOfColumns];

        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            Row row = table.row(rowIndex);

            for (int rowColumn = 1; rowColumn <= numberOfColumns; rowColumn++) {
                try {
                    if (table.column(rowColumn).name().equals("rodada")) {
                        matrix[rowIndex][rowColumn-1] = row.getInt(rowColumn)/38.0;
                    }   
                    else {
                        matrix[rowIndex][rowColumn-1] = row.getInt(rowColumn);
                    }
                } catch (IllegalArgumentException e) {
                    matrix[rowIndex][rowColumn-1] = row.getTime(rowColumn).getHour()/24.0;
                }
            }
        }

        return matrix;
    } 

    public static List<Tuple<Matrix, Matrix>> generateTuple(Table inputData, Table outputData) {
        double[][] inputArrayBidimensional = tableToArrayTransformer(inputData);
        double[][] outputArrayBidimensional = tableToArrayTransformer(outputData);

        int numberOfRows = inputArrayBidimensional.length;

        List<Tuple<Matrix, Matrix>> inputOutputList = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            double[][] tempInputRow = {inputArrayBidimensional[rowIndex]};
            double[][] tempOutputRow = {outputArrayBidimensional[rowIndex]};

            Matrix tempInputMatrix = new Matrix(tempInputRow);
            Matrix tempOutputMatrix = new Matrix(tempOutputRow);

            Matrix inputMatrix = new Matrix(inputArrayBidimensional[0].length, 1);
            Matrix outputMatrix = new Matrix(outputArrayBidimensional[0].length, 1);

            inputMatrix = Matrix.transpose(tempInputMatrix);
            outputMatrix = Matrix.transpose(tempOutputMatrix);

            Tuple<Matrix, Matrix> tupleMatrix = new Tuple<Matrix, Matrix>(inputMatrix, outputMatrix);

            inputOutputList.add(tupleMatrix);
        }       

        return inputOutputList;
    }
}