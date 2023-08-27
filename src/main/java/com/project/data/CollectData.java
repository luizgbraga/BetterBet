package com.project.data;

import java.util.HashMap;

import tech.tablesaw.api.Table;

public class CollectData {
    static String csvName = "brasileirao.csv";
    
    static Table totalData = Table.read().csv(csvName);

    public static void main(String[] args) {
        System.out.println(totalData.structure());
    }

    public static HashMap<String, Table> generateTrainingAndTestData() {
        Table totalDataCopy = totalData.copy();

        Table[] sampleData = totalDataCopy.sampleSplit(0.1);

        Table testingData = sampleData[0];
        Table trainingData = sampleData[1];

        HashMap<String, Table> hashMap = new HashMap<String, Table>();

        hashMap.put("trainingData", trainingData);
        hashMap.put("testingData", testingData);

        return hashMap;
    }

    public static Table getAllData() {
        return totalData;
    }
}