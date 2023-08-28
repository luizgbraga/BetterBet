package com.project;

import java.util.List;

import com.project.network.NeuralNetwork;

// 1: palmeiras
// 2: flamengo
// rodada
// ambosmarcam, somagols>2,somagols>3

public class Main {
    static double [][] X= {
		{1,2,43,16},
		{1,2,36,20},
		{1,2,28,16},
		{1,2,20,16},
		{1,2,16,21},
		{1,2,30,16},
		{1,2,6,22},
		{1,2,10,22},
		{1,2,17,22},
	};
	static double [][] Y= {
		{1,1,0},
        {0,0,0},
        {1,1,1},
        {1,1,0},
        {0,0,0},
        {0,0,0},
        {0,0,0},
        {0,0,0},
        {0,0,0}
	};

	public static void main(String[] args) {
		
		NeuralNetwork nn = new NeuralNetwork(4,10,3);
		
		List<Double>output;
		
		nn.fit(X, Y, 50000);
		double [][] input = {
				{1,2,22,22},
                {1,2,19,11},
                {1,2,25,22},
                {1,2,34,17},	
		};
		for(double d[]:input)
		{
			output = nn.predict(d);
			System.out.println(output.toString());
		}		

	}

}
