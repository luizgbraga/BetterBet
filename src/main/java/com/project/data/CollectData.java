package com.project.data;

import java.util.ArrayList;
import java.util.HashMap;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

public class CollectData {
    static String csvName = "brasileirao.csv";
    
    static Table totalData = Table.read().csv(csvName);

    public static HashMap<String, Integer> clubId = new HashMap<String, Integer>();

    public static void main(String[] args) {        
        int numberOfColumns = totalData.columnCount();
        // Removes all columns from "bs" until the end to recalculate them
        for (int columnIndex = 7; columnIndex < numberOfColumns; columnIndex++) {
            totalData.removeColumns(7);
        }

        updateClubId();

        HashMap<Integer, IntColumn> idColumns = new HashMap<Integer, IntColumn>();

        for (int i = 1; i <= clubId.size(); i++) {
            IntColumn idColumn = IntColumn.create("id" + String.valueOf(i));
            idColumns.put(i, idColumn);
        }

        IntColumn bothScore = IntColumn.create("bs");
        IntColumn noGoals = IntColumn.create("zero_gols");
        IntColumn moreThan1Goal = IntColumn.create("mt1g");
        IntColumn moreThan2Goal = IntColumn.create("mt2g");
        IntColumn moreThan3Goal = IntColumn.create("mt3g");
        IntColumn moreThan4Goal = IntColumn.create("mt4g");
        IntColumn moreThan5Goal = IntColumn.create("mt5g");
        IntColumn differenceMoreThanOrEqual2Goals = IntColumn.create("dgt2");
        IntColumn differenceMoreThanOrEqual3Goals = IntColumn.create("dgt3");

        for (Row row : totalData) {
            String homeClubName = row.getString("mandante");
            String visitorClubName = row.getString("visitante");

            if (row.getInt("mandante_placar") != 0 && row.getInt("visitante_placar") != 0) {
                bothScore.append(1);
            } else {
                bothScore.append(0);
            }

            if (row.getInt("mandante_placar") + row.getInt("visitante_placar") == 0) {
                noGoals.append(1);
            } else {
                noGoals.append(0);
            }

            if (row.getInt("mandante_placar") + row.getInt("visitante_placar") > 1) {
                moreThan1Goal.append(1);
            } else {
                moreThan1Goal.append(0);
            }

            if (row.getInt("mandante_placar") + row.getInt("visitante_placar") > 2) {
                moreThan2Goal.append(1);
            } else {
                moreThan2Goal.append(0);
            }

            if (row.getInt("mandante_placar") + row.getInt("visitante_placar") > 3) {
                moreThan3Goal.append(1);
            } else {
                moreThan3Goal.append(0);
            }

            if (row.getInt("mandante_placar") + row.getInt("visitante_placar") > 4) {
                moreThan4Goal.append(1);
            } else {
                moreThan4Goal.append(0);
            }

            if (row.getInt("mandante_placar") + row.getInt("visitante_placar") > 5) {
                moreThan5Goal.append(1);
            } else {
                moreThan5Goal.append(0);
            }

            if (Math.abs(row.getInt("mandante_placar") - row.getInt("visitante_placar")) >= 2) {
                differenceMoreThanOrEqual2Goals.append(1);
            } else {
                differenceMoreThanOrEqual2Goals.append(0);
            }

            if (Math.abs(row.getInt("mandante_placar") - row.getInt("visitante_placar")) >= 3) {
                differenceMoreThanOrEqual3Goals.append(1);
            } else {
                differenceMoreThanOrEqual3Goals.append(0);
            }

            for (int i = 1; i <= idColumns.size(); i++) {
                if (clubId.get(homeClubName) == i || clubId.get(visitorClubName) == i) {
                    idColumns.get(i).append(1);
                }
                else {
                    idColumns.get(i).append(0);
                }
            }
        }

        totalData.addColumns(bothScore, moreThan1Goal, moreThan2Goal,
                            moreThan3Goal, moreThan4Goal, moreThan5Goal, differenceMoreThanOrEqual2Goals,
                            differenceMoreThanOrEqual3Goals, noGoals);

        for (int i = 1; i <= idColumns.size(); i++) {
            totalData.addColumns(idColumns.get(i));
        }

        try {    
            FileWriter fileWriter = new FileWriter(csvName);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            ArrayList<String> idColumnNames = new ArrayList<String>();

            for (int i = 1; i <= idColumns.size(); i++) {
                idColumnNames.add(idColumns.get(i).name());
            }

            String[] columnNames = {"ID", "rodada", "hora", "mandante", "visitante", "mandante_placar", "visitante_placar",
                                    "bs", "mt1g", "mt2g", "mt3g", "mt4g", "mt5g", "dgt2", "dgt3", "zero_gols"};

            String[] combinedColumns = new String[columnNames.length + idColumnNames.size()];

            for (int i = 0; i < columnNames.length; i++) {
                combinedColumns[i] = columnNames[i];
            }

            for (int i = columnNames.length; i < combinedColumns.length; i++) {
                combinedColumns[i] = idColumnNames.get(i - columnNames.length);
            }

            csvWriter.writeNext(combinedColumns, false);

            for (Row row : totalData) {
                String[] rowData = {
                    String.valueOf(row.getInt("ID")),
                    String.valueOf(row.getInt("rodada")),
                    String.valueOf(row.getTime("hora")),
                    row.getString("mandante"),
                    row.getString("visitante"),
                    String.valueOf(row.getInt("mandante_placar")),
                    String.valueOf(row.getInt("visitante_placar")),
                    String.valueOf(row.getInt("bs")),
                    String.valueOf(row.getInt("mt1g")),
                    String.valueOf(row.getInt("mt2g")),
                    String.valueOf(row.getInt("mt3g")),
                    String.valueOf(row.getInt("mt4g")),
                    String.valueOf(row.getInt("mt5g")),
                    String.valueOf(row.getInt("dgt2")),
                    String.valueOf(row.getInt("dgt3")),
                    String.valueOf(row.getInt("zero_gols"))
                };

                String[] combinedRowData = new String[combinedColumns.length];

                for (int i = 0; i < rowData.length; i++) {
                    combinedRowData[i] = rowData[i];
                }

                for (int i = rowData.length; i < combinedRowData.length; i++) {
                    combinedRowData[i] = String.valueOf(row.getInt(i));
                }

                csvWriter.writeNext(combinedRowData, false);            
            }

            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        totalData = Table.read().csv(csvName);
    }

    public static HashMap<String, Table> generateTrainingAndTestData() {
        updateClubId();

        Table totalDataCopy = totalData.copy();

        Table[] sampleData = totalDataCopy.sampleSplit(0.1);

        Table testingData = sampleData[0];
        Table trainingData = sampleData[1];

        String[] inputColumnsWithoutId = {"ID", "hora", "rodada"};

        String[] inputColumnsWithId = new String[inputColumnsWithoutId.length + clubId.size()];
        
        inputColumnsWithId[0] = inputColumnsWithoutId[0];
        inputColumnsWithId[1] = inputColumnsWithoutId[1];
        inputColumnsWithId[2] = inputColumnsWithoutId[2];

        for (int i = 0; i < clubId.size(); i++) {
            inputColumnsWithId[i+3] = "id" + String.valueOf(i+1);
        }

        String[] outputColumns = {"ID", "bs", "mt1g", "mt2g", "mt3g",
                                "mt4g", "mt5g", "dgt2", "dgt3",
                                "zero_gols"};

        Table trainingInput = trainingData.copy();
        Table trainingOutput = trainingData.copy();
        Table trainingDataInput = trainingInput.retainColumns(inputColumnsWithId);
        Table trainingDataOutput = trainingOutput.retainColumns(outputColumns);

        Table testingInput = testingData.copy();
        Table testingOutput = testingData.copy();
        Table testingDataInput = testingInput.retainColumns(inputColumnsWithId);
        Table testingDataOutput = testingOutput.retainColumns(outputColumns);

        HashMap<String, Table> hashMap = new HashMap<String, Table>();

        hashMap.put("trainingDataInput", trainingDataInput);
        hashMap.put("trainingDataOutput", trainingDataOutput);
        hashMap.put("testingDataInput", testingDataInput);
        hashMap.put("testingDataOutput", testingDataOutput);

        return hashMap;
    }

    public static Table getAllData() {
        return totalData;
    }

    static void updateClubId() {
        HashMap<String, Integer> clubIdBuilder = new HashMap<String, Integer>();

        int id = 1;

        for (int rowIndex = 0; rowIndex < totalData.rowCount(); rowIndex++) {
            String homeClubName = totalData.stringColumn("mandante").get(rowIndex);
            String visitorClubName = totalData.stringColumn("visitante").get(rowIndex);

            if (!clubIdBuilder.containsKey(homeClubName)){
                clubIdBuilder.put(homeClubName, id);
                id += 1;
            }
            if (!clubIdBuilder.containsKey(visitorClubName)){
                clubIdBuilder.put(visitorClubName, id);
                id += 1;
            }
        }

        clubId = clubIdBuilder;
    }

    public static ArrayList<String> getAllTeams() {
        ArrayList<String> teams = new ArrayList<String>();

        for (Row row : totalData) {
            String homeClubName = row.getString("mandante");
            String visitorClubName = row.getString("visitante");

            if (!teams.contains(homeClubName)) {
                teams.add(homeClubName);
            }

            if (!teams.contains(visitorClubName)) {
                teams.add(visitorClubName);
            }
        }

        return teams;
    }
}