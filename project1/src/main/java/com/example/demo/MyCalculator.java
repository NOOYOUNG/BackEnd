package com.example.demo;

public class MyCalculator {
	public String calAdd(int a, int b, CalAdd calAdd) {
		int value=calAdd.doOperation(a, b);
		System.out.println("result: "+value);
		return a+"+"+b+"="+value;
	}
	
	public String calSub(int a, int b, CalSub calSub) {;
		int value=calSub.doOperation(a, b);
		System.out.println("result: "+value);
		return a+"-"+b+"="+value;
	}
	
	public String calMul(int a, int b, CalMul calMul) {
		int value=calMul.doOperation(a, b);
		System.out.println("result: "+value);
		return a+"*"+b+"="+value;
	}
	
	public String calDiv(int a, int b, CalDiv calDiv) {
		int value=calDiv.doOperation(a, b);
		System.out.println("result: "+value);
		return a+"/"+b+"="+value;
	}

}
