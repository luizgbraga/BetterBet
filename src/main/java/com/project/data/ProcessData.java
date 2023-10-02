package com.project.data;

import com.project.util.Matrix;
import com.project.util.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

/**
 * Class for processing data
 * @author Diogo Laurindo
 */

public class ProcessData {
    
    /** 
     * Function only for testing the output of ProcessData methods
     */
    public static void main(String[] args) {
        HashMap<String, Table> hashMap = CollectData.generateTrainingAndTestData();

        // Only for testing data integrity
        // Use System.out.println(Arrays.deepToString(nameOfMatrix)) to display all data in form of matrix
        List<Tuple<Matrix, Matrix>> list = generateTuple(hashMap.get("trainingDataInput"), hashMap.get("trainingDataOutput"));
        list.get(0).getX().displayMatrix();
        list.get(0).getY().displayMatrix();
    }

    /**
     * A function that transforms a Table into a bidimensional array
     * @param table table that will be transformed
     * @return bidimensional array with all table data
     */
    public static double[][] tableToArrayTransformer(Table table) {
        int numberOfColumns = table.columnCount() - 1;
        int numberOfRows = table.rowCount();

        double[][] matrix = new double[numberOfRows][numberOfColumns];

        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            Row row = table.row(rowIndex);

            for (int rowColumn = 1; rowColumn <= numberOfColumns; rowColumn++) {
                try {
                    if (table.column(rowColumn).name().equals("rodada")) {
                        matrix[rowIndex][rowColumn - 1] = row.getInt(rowColumn)/38.0;
                    }   
                    else {
                        matrix[rowIndex][rowColumn - 1] = row.getInt(rowColumn);
                    }
                } catch (IllegalArgumentException e) {
                    matrix[rowIndex][rowColumn - 1] = row.getTime(rowColumn).getHour()/24.0;
                }
            }
        }

        return matrix;
    } 
    
    /** 
     * Function that transforms two tables, input and output data, into a list of tuples that 
     * consists of an input from a match, and the respective output for that match
     * @param inputData table that contains all of the input data
     * @param outputData table that contains all of the expected output data
     * @return list of tuples with input and output data for each tuple
     */
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

    /**
     * Function that formats the input data into a matrix that will serve as input to the machine learning model
     * @param homeClubId id of the home club
     * @param visitorClubId id of the visitor club
     * @param hour hour of the match
     * @param round round of championship
     * @return matrix will all of that data formatted
     */
    public static Matrix formatInputData(int homeClubId, int visitorClubId, double hour, double round) {
        HashMap<String, Integer> clubId = CollectData.clubId;

        double[][] inputData = new double[1][clubId.size()+2];

        inputData[0][0] = hour;
        inputData[0][1] = round;

        for (int i = 2; i < clubId.size()+2; i++) {
            if (homeClubId == i-1 || visitorClubId == i-1) {
                inputData[0][i] = 1;
            }
            else {
                inputData[0][i] = 0;
            }
        }

        Matrix inputDataMatrix = new Matrix(inputData);

        return Matrix.transpose(inputDataMatrix);
    }

    /**
     * Function that gets the output matrix from the inputForm screen and returns an array of bets to do
     * @param output matrix that represents the inputForm data
     * @return array of strings with the bets to do
     */
    public static String[] outputToArray(Matrix output) {
        HashMap<String, Double> bets = new HashMap<String, Double>();
        double[][] outputArray = output.getData();
        bets.put("Ambos marcam",outputArray[0][0]);
        bets.put("Mais de 1 gol", outputArray[1][0]);
        bets.put("Mais de 2 gols", outputArray[2][0]);
        bets.put("Mais de 3 gols", outputArray[3][0]);
        bets.put("Mais de 4 gols", outputArray[4][0]);
        bets.put("Mais de 5 gols", outputArray[5][0]);
        bets.put("Diferença maior de 2 gols", outputArray[6][0]);
        bets.put("Diferença maior de 3 gols", outputArray[7][0]);
        bets.put("Sem gols", outputArray[8][0]);

        ArrayList<String> betsToDo = new ArrayList<String>();

        for (Map.Entry<String, Double> entrie : bets.entrySet()) {
            String key = entrie.getKey();
            double value = entrie.getValue();

            if (value == 1) {
                betsToDo.add(key);
            }
        }

        String[] betsToDoArray = new String[betsToDo.size()];
        betsToDoArray = betsToDo.toArray(betsToDoArray);
        
        return betsToDoArray;
    }
}
