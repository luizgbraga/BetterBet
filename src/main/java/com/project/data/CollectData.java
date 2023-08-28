package com.project.data;

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

        HashMap<String, Integer> clubIdBuilder = new HashMap<String, Integer>();
        int id = 1;

        for (int rowIndex = 0; rowIndex < totalData.rowCount(); rowIndex++) {
            String homeClubName = totalData.stringColumn("mandante").get(rowIndex);
            String visitorClubName = totalData.stringColumn("visitante").get(rowIndex);

            if (!clubIdBuilder.containsKey(homeClubName)){
                clubIdBuilder.put(homeClubName, id++);
            }
            if (!clubIdBuilder.containsKey(visitorClubName)){
                clubIdBuilder.put(visitorClubName, id++);
            }
        }

        clubId = clubIdBuilder;

        IntColumn homeClubId = IntColumn.create("mandanteID");
        IntColumn visitorClubId = IntColumn.create("visitanteID");
        IntColumn bothScore = IntColumn.create("ambos_marcam");
        IntColumn noGoals = IntColumn.create("zero_gols");
        IntColumn moreThan1Goal = IntColumn.create("mais_que_1_gol");
        IntColumn moreThan2Goal = IntColumn.create("mais_que_2_gol");
        IntColumn moreThan3Goal = IntColumn.create("mais_que_3_gol");
        IntColumn moreThan4Goal = IntColumn.create("mais_que_4_gol");
        IntColumn moreThan5Goal = IntColumn.create("mais_que_5_gol");
        IntColumn differenceMoreThanOrEqual2Goals = IntColumn.create("diferenca_maior_igual_2");
        IntColumn differenceMoreThanOrEqual3Goals = IntColumn.create("diferenca_maior_igual_3");

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

            homeClubId.append(clubId.get(homeClubName));
            visitorClubId.append(clubId.get(visitorClubName));
        }

        totalData.addColumns(homeClubId, visitorClubId, bothScore, moreThan1Goal, moreThan2Goal,
                            moreThan3Goal, moreThan4Goal, moreThan5Goal, differenceMoreThanOrEqual2Goals,
                            differenceMoreThanOrEqual3Goals, noGoals);

        try {    
            FileWriter fileWriter = new FileWriter(csvName);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] columnNames = {"ID", "rodada", "hora", "mandante", "visitante", "mandante_placar", "visitante_placar",
                                "mandante_estado", "visitante_estado", "gcontra_mandante", "gcontra_visitante", "penalti_mandante",
                                "penalti_visitante", "mandanteID", "visitanteID", "ambos_marcam", "mais_que_1_gol", "mais_que_2_gol",
                                "mais_que_3_gol", "mais_que_4_gol", "mais_que_5_gol", "diferenca_maior_igual_2", "diferenca_maior_igual_3",
                                "zero_gols"};

            csvWriter.writeNext(columnNames, false);

            for (Row row : totalData) {
                String[] rowData = {
                    String.valueOf(row.getInt("ID")),
                    String.valueOf(row.getInt("rodada")),
                    String.valueOf(row.getTime("hora")),
                    row.getString("mandante"),
                    row.getString("visitante"),
                    String.valueOf(row.getInt("mandante_placar")),
                    String.valueOf(row.getInt("visitante_placar")),
                    row.getString("mandante_estado"),
                    row.getString("visitante_estado"),
                    String.valueOf(row.getInt("gcontra_mandante")),
                    String.valueOf(row.getInt("gcontra_visitante")),
                    String.valueOf(row.getInt("penalti_mandante")),
                    String.valueOf(row.getInt("penalti_visitante")),
                    String.valueOf(row.getInt("mandanteID")),
                    String.valueOf(row.getInt("visitanteID")),
                    String.valueOf(row.getInt("ambos_marcam")),
                    String.valueOf(row.getInt("mais_que_1_gol")),
                    String.valueOf(row.getInt("mais_que_2_gol")),
                    String.valueOf(row.getInt("mais_que_3_gol")),
                    String.valueOf(row.getInt("mais_que_4_gol")),
                    String.valueOf(row.getInt("mais_que_5_gol")),
                    String.valueOf(row.getInt("diferenca_maior_igual_2")),
                    String.valueOf(row.getInt("diferenca_maior_igual_3")),
                    String.valueOf(row.getInt("zero_gols"))
                };

                csvWriter.writeNext(rowData, false);            
            }

            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Table> generateTrainingAndTestData() {
        Table totalDataCopy = totalData.copy();

        Table[] sampleData = totalDataCopy.sampleSplit(0.1);

        Table testingData = sampleData[0];
        Table trainingData = sampleData[1];

        String[] inputColumns = {"ID", "hora", "mandanteID", "visitanteID", "mandante_estado", "visitante_estado"};
        String[] outputColumns = {"ID", "ambos_marcam", "mais_que_1_gol", "mais_que_2_gol", "mais_que_3_gol",
                                "mais_que_4_gol", "mais_que_5_gol", "diferenca_maior_igual_2", "diferenca_maior_igual_3",
                                "zero_gols"};

        Table trainingDataInput = trainingData.retainColumns(inputColumns);
        Table trainingDataOutput = trainingData.retainColumns(outputColumns);

        Table testingDataInput = testingData.retainColumns(inputColumns);
        Table testingDataOutput = testingData.retainColumns(outputColumns);

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
}