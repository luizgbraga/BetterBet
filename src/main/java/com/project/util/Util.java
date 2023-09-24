package com.project.util;

/**
 * Class with useful functions
 * @author Luiz Guilherme Amadi Braga
 */
public class Util {
    
    /** 
     * Sigmoid function
     * @param x
     * @return double
     */
    public static double sigmoid(double x) {
        return 1/(1 + Math.exp(-x));
    }

    
    /** 
     * Derivative of sigmoid function
     * @param x
     * @return double
     */
    public static double dsigmoid(double x) {
        return sigmoid(x) * (1 - sigmoid(x));
    }
}
