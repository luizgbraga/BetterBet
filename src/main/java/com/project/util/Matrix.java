package com.project.util;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private double [][]data;
    private int rows, columns;

    public Matrix(int rows, int columns) {
        this.data = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;
        Random random = new Random();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                data[i][j] = random.nextDouble(-1, 1);
            }
        }
    }

    public boolean isEqualShape(Matrix m) {
        return (this.rows == m.rows && this.columns == m.columns);
    }

    public boolean isMultipliable(Matrix m) {
        return (this.rows == m.columns && this.columns == m.rows);
    }

    public void add(double scalar) {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.data[i][j] += scalar;
            }
        }
    }

    public void add(Matrix m) {
        if(!this.isEqualShape(m)) {
            System.out.println("Sum error: shape mismatch");
            return;
        }
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.data[i][j] += m.data[i][j];
            }
        }
    }

    public static Matrix subtract(Matrix a, Matrix b) {
        Matrix aux = new Matrix(a.rows, a.columns);
        for(int i = 0; i < a.rows; i++) {
            for(int j = 0; j < a.columns; j++) {
                aux.data[i][j] += a.data[i][j] - b.data[i][j];
            }
        }
        return aux;
    }

    public void multiply(double scalar) {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.data[i][j] *= scalar;
            }
        }
    }

    public void multiply(Matrix m) {
        if(!this.isEqualShape(m)) {
            System.out.println("Multiplying errork: shape mismatch");
            return;
        }
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.data[i][j] *= m.data[i][j];
            }
        }
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        Matrix aux = new Matrix(a.rows, b.columns);
        for(int i = 0; i < aux.rows; i++) {
            for(int j = 0; j < aux.columns; j++) {
                double sum = 0;
                for(int k = 0; k < a.columns; k++) {
                    sum += a.data[i][k] * b.data[k][j];
                }
                aux.data[i][j] = sum;
            }
        }
        return aux;
    }

    public static Matrix transpose(Matrix m) {
        Matrix aux = new Matrix(m.columns, m.rows);
        for(int i = 0; i < m.rows; i++) {
            for(int j = 0; j < m.columns; j++) {
                aux.data[j][i] = m.data[i][j];
            }
        }
        return aux;
    }

    public void sigmoid() {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.data[i][j] = Util.sigmoid(this.data[i][j]);
            }
        }
    }

	public Matrix dsigmoid() {
		Matrix temp=new Matrix(rows,columns);
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
				temp.data[i][j] = this.data[i][j] * (1-this.data[i][j]);
		}
		return temp;
		
	}

    public static Matrix fromArray(double[] arr) {
        Matrix aux = new Matrix(arr.length, 1);
        for(int i = 0; i < arr.length; i++) {
            aux.data[i][0] = arr[i];
        }
        return aux;
    }

    public List<Double> toArray() {
        List<Double> aux = new ArrayList<Double>();
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                aux.add(data[i][j]);
            }
        }
        return aux;
    }
}
