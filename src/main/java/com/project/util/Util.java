package com.project.util;

public class Util {
    public static double sigmoid(double x) {
        return 1/(1 + Math.exp(-x));
    }

    public static double dsigmoid(double x) {
        return sigmoid(x) * (1 - sigmoid(x));
    }
}
