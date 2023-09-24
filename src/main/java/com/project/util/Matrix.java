package com.project.util;

import java.util.Random;

/**
 * Class for helping matrix treatments along the network
 * It is important to notice that most methods in this class do NOT modify the this, and that is why they are static
 * @author Luiz Guilherme Amadi Braga
 */
public class Matrix {

    private double[][] data;
    private int rows, columns;

    /**
     * This constructor initializes the matrix with random values following a gaussian distribution 
     * @param rows
     * @param columns
     */
    public Matrix(int rows, int columns) {
        this.data = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextGaussian();
            }
        }
    }

    /** 
     * This constructor initializes the matrix with 0s in all entries 
     * @param rows
     * @param columns
     * @param zero (this constructor is called when zero is passed as true)
     */
    public Matrix(int rows, int columns, boolean zero) {
        this.data = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    /** 
     * This constructor initializes the matrix with the values passed in data 
     * @param data
     */
    public Matrix(double[][] data) {
        this.data = data;
        this.rows = data.length;
        this.columns = data[0].length;
    }
    
    /** 
     * Rows getter
     * @return int
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Columns getter
     * @return int
     */
    public int getColumns() {
        return this.columns;
    }
    
    /**
     * Data getter
     * @return double[][]
     */
    public double[][] getData() {
        return this.data;
    }

    /**
     * Print the matrix formatted with two floating values
     */
    public void displayMatrix() {
        for (int i = 0; i < this.rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < this.columns - 1; j++) {
                System.out.printf("%s%.2f ", this.data[i][j] > 0 ? "+" : "", this.data[i][j]);
            }
            System.out.printf("%s%.2f |\n", this.data[i][this.columns - 1] > 0 ? "+" : "", this.data[i][this.columns - 1]);
        }
        System.out.println();
    }

    /** 
     * Sets matrix[i][j] = element
     * @param i
     * @param j 
     * @param element
     * @throws IllegalArgumentException
     */
    public void setPosition(int i, int j, double element) throws IllegalArgumentException {
        if (i > this.rows || j > this.columns) {
            throw new IllegalArgumentException("Set position error: out of bounds");
        }
        this.data[i][j] = element;
    }

    /** 
     * Makes a copy of this and returns
     * @return Matrix
     */
    public Matrix copy() {
        Matrix matrixCopy = new Matrix(this.rows, this.columns);
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                matrixCopy.data[i][j] = this.data[i][j];
            }
        }
        return matrixCopy;
    }    
    
    /** 
     * Sums every matrix element to a scalar
     * @param m
     * @param scalar
     * @return Matrix
     */
    static public Matrix add(Matrix m, double scalar) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for(int i = 0; i < m.rows; i++) {
            for(int j = 0; j < m.columns; j++) {
                temp.data[i][j] = m.data[i][j] + scalar;
            }
        }
        return temp;
    }

    
    /** 
     * Sums a matrix to another matrix, term by term
     * @param m
     * @param n
     * @return Matrix
     * @throws IllegalArgumentException
     */
    static public Matrix add(Matrix m, Matrix n) throws IllegalArgumentException {
        if (m.rows != n.rows || m.columns != n.columns) {
            throw new IllegalArgumentException("Sum error: shape mismatch");
        }
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for(int j = 0; j < m.columns; j++) {
                temp.data[i][j] = m.data[i][j] + n.data[i][j];
            }
        }
        return temp;
    }

    
    /** 
     * Subtracts a matrix from another matrix, term by term
     * @param m
     * @param n
     * @return Matrix
     * @throws IllegalArgumentException
     */
    static public Matrix subtract(Matrix m, Matrix n) throws IllegalArgumentException {
        if (m.rows != n.rows || m.columns != n.columns) {
            throw new IllegalArgumentException("Subtract error: shape mismatch");
        }
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for(int j = 0; j < m.columns; j++) {
                temp.data[i][j] = m.data[i][j] - n.data[i][j];
            }
        }
        return temp;
    }

    
    /** 
     * Returns the sum of the squares of every matrix element
     * @param m
     * @return double
     */
    static public double sumSquare(Matrix m) {
        double sum = 0;
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                sum += m.data[i][j] * m.data[i][j];
            }
        }
        return sum;
    }

    
    /** 
     * Multiply every matrix element to a scalar
     * @param m
     * @param scalar
     * @return Matrix
     */
    static public Matrix multiply(Matrix m, double scalar) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[i][j] = m.data[i][j] * scalar;
            }
        }
        return temp;
    }

    
    /** 
     * Multiplication of matrices (default way)
     * @param m
     * @param n
     * @return Matrix
     * @throws IllegalArgumentException
     */
    static public Matrix multiply(Matrix m, Matrix n) throws IllegalArgumentException {
        if (m.columns != n.rows) {
            throw new IllegalArgumentException("Multiplying error: shape mismatch");
        }
        Matrix temp = new Matrix(m.rows, n.columns);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < n.columns; j++) {
                temp.data[i][j] = 0;
                for (int k = 0; k < m.columns; k++) {
                    temp.data[i][j] += m.data[i][k] * n.data[k][j];
                }
            }
        }
        return temp;
    }

    
    /** 
     * Multiplies two matrices term by term
     * @param m
     * @param n
     * @return Matrix
     * @throws IllegalArgumentException
     */
    static public Matrix dot(Matrix m, Matrix n) throws IllegalArgumentException {
        if (m.rows != n.rows || m.columns != n.columns) {
            throw new IllegalArgumentException("Dot error: shape mismatch");
        }
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for(int j = 0; j < m.columns; j++) {
                temp.data[i][j] = m.data[i][j] * n.data[i][j];
            }
        }
        return temp;
    }


    
    /**
     * Transposes matrix
     * @param m
     * @return Matrix
     */
    static public Matrix transpose(Matrix m) {
        Matrix temp = new Matrix(m.columns, m.rows);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[j][i] = m.data[i][j];
            }
        }
        return temp;
    }

    
    /** 
     * Applies sigmoid function to every matrix element
     * @param m
     * @return Matrix
     */
    static public Matrix sigmoid(Matrix m) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[i][j] = Util.sigmoid(m.data[i][j]);
            }
        }
        return temp;
    }

    
    /** 
     * Applies the derivative of sigmoid function to every matrix element
     * @param m
     * @return Matrix
     */
    static public Matrix dsigmoid(Matrix m) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[i][j] = Util.dsigmoid(m.data[i][j]);
            }
        }
        return temp;
    }

    /** 
     * Rounds every matrix entrie to 0 or 1, based on a risk
     * @param m
     * @param risk
     * @return Matrix
     */
    static public Matrix round(Matrix m, double risk) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[i][j] = m.data[i][j] > (1 - risk) ? 1 : 0;
            }
        }
        return temp;
    }
}
