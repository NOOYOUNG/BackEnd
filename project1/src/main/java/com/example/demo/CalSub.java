package com.example.demo;

public class CalSub implements ICalculator{
	@Override
	public int doOperation(int fNum, int sNum) {
		return fNum-sNum;
	}
}
