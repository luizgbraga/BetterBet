package com.project.data;

import java.util.Arrays;
import java.util.HashMap;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

public class ProcessData {
    public static void main(String[] args) {
        HashMap<String, Table> hashMap = CollectData.generateTrainingAndTestData();

        // Only for testing data integrity
        // Use System.out.println(Arrays.deepToString(nameOfMatrix)) to display all data in form of matrix
        double[][] trainingDataInputMatrix = generateMatrix(hashMap.get("trainingDataInput"));
        double[][] trainingDataOutputMatrix = generateMatrix(hashMap.get("trainingDataOutput"));
        double[][] testingDataInputMatrix = generateMatrix(hashMap.get("testingDataInput"));
        double[][] testingDataOutputMatrix = generateMatrix(hashMap.get("testingDataOutput"));

        System.out.println(Arrays.deepToString(trainingDataInputMatrix));
        System.out.println(Arrays.deepToString(trainingDataOutputMatrix));

    }

    public static double[][] generateMatrix(Table table) {
        int numberOfColumns = table.columnCount() - 1;
        int numberOfRows = table.rowCount();

        double[][] matrix = new double[numberOfRows][numberOfColumns];

        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            Row row = table.row(rowIndex);

            for (int rowColumn = 1; rowColumn <= numberOfColumns; rowColumn++) {
                try {
                    matrix[rowIndex][rowColumn-1] = row.getInt(rowColumn);
                } catch (IllegalArgumentException e) {
                    matrix[rowIndex][rowColumn-1] = row.getTime(rowColumn).getHour();
                }
            }
        }

        return matrix;
    } 
}