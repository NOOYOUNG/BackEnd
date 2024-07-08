package com.example.demo;

public class CalDiv implements ICalculator{
	@Override
	public int doOperation(int fNum, int sNum) {
		return sNum!=0 ? (fNum/sNum) : 0;
	}
}
