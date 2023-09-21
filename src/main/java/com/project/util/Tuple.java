package com.project.util;

public class Tuple<X, Y> {
    private X x;
    private Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    
    /** 
     * @return X
     */
    public X getX() {
        return x;
    }

    
    /** 
     * @return Y
     */
    public Y getY() {
        return y;
    }
}
