package com.example.demo;

public class MyCalculator {
	public void calculate(int fnum, int snum, ICalculator calculator) {
		int value=calculator.doOperation(fnum, snum);
		System.out.println("result: "+value);
	}

	
//	public void calAdd(int a, int b, CalAdd calAdd) {
//		//ICalculator calculator=new CalAdd();
//		int value=calAdd.doOperation(a, b);
//		System.out.println("result: "+value);
//	}
//	
//	public void calSub(int a, int b, CalSub calSub) {
//		//ICalculator calculator=new CalSub();
//		int value=calSub.doOperation(a, b);
//		System.out.println("result: "+value);
//	}
//	
//	public void calMul(int a, int b, CalMul calMul) {
//		//ICalculator calculator=new CalMul();
//		int value=calMul.doOperation(a, b);
//		System.out.println("result: "+value);
//	}
//	
//	public void calDiv(int a, int b, CalDiv calDiv) {
//		//ICalculator calculator=new CalDiv();
//		int value=calDiv.doOperation(a, b);
//		System.out.println("result: "+value);
//	}

}
