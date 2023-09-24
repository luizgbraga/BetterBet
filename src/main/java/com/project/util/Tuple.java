package com.project.util;

/**
 * Class for treating ordered pairs of things
 * @author Luiz Guilherme Amadi Braga
 */
public class Tuple<X, Y> {
    private X x;
    private Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
    
    /** 
     * X getter
     * @return X
     */
    public X getX() {
        return x;
    }
    
    /** 
     * Y getter
     * @return Y
     */
    public Y getY() {
        return y;
    }
}
