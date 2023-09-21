package com.project.util;

public class Util {
    
    /** 
     * @param x
     * @return double
     */
    public static double sigmoid(double x) {
        return 1/(1 + Math.exp(-x));
    }

    
    /** 
     * @param x
     * @return double
     */
    public static double dsigmoid(double x) {
        return sigmoid(x) * (1 - sigmoid(x));
    }
}
