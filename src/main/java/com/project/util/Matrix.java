package com.project.util;

import java.util.Random;

public class Matrix {

    private double[][] data;
    private int rows, columns;

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

    public Matrix(int rows, int columns, boolean zero) {
        this.data = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public Matrix(double[][] data) {
        this.data = data;
        this.rows = data.length;
        this.columns = data[0].length;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public double[][] getData() {
        return this.data;
    }

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

    public void setPosition(int i, int j, double element) throws IllegalArgumentException {
        if (i > this.rows || j > this.columns) {
            throw new IllegalArgumentException("Set position error: out of bounds");
        }
        this.data[i][j] = element;
    }

    public Matrix copy() {
        Matrix matrixCopy = new Matrix(this.rows, this.columns);
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                matrixCopy.data[i][j] = this.data[i][j];
            }
        }
        return matrixCopy;
    }    

    static public Matrix add(Matrix m, double scalar) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for(int i = 0; i < m.rows; i++) {
            for(int j = 0; j < m.columns; j++) {
                temp.data[i][j] = m.data[i][j] + scalar;
            }
        }
        return temp;
    }

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

    static public double sumSquare(Matrix m) {
        double sum = 0;
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                sum += m.data[i][j] * m.data[i][j];
            }
        }
        return sum;
    }

    static public Matrix multiply(Matrix m, double scalar) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[i][j] = m.data[i][j] * scalar;
            }
        }
        return temp;
    }

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


    static public Matrix transpose(Matrix m) {
        Matrix temp = new Matrix(m.columns, m.rows);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[j][i] = m.data[i][j];
            }
        }
        return temp;
    }

    static public Matrix sigmoid(Matrix m) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[i][j] = Util.sigmoid(m.data[i][j]);
            }
        }
        return temp;
    }

    static public Matrix dsigmoid(Matrix m) {
        Matrix temp = new Matrix(m.rows, m.columns);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                temp.data[i][j] = Util.dsigmoid(m.data[i][j]);
            }
        }
        return temp;
    }
}
