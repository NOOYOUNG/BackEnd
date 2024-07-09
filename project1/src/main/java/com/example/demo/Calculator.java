package com.example.demo;

public class Calculator {
	public int add(String a, String b) {
		return Integer.parseInt(a)+Integer.parseInt(b);
	}
	
	public int sub(String a, String b) {
		return Integer.parseInt(a)-Integer.parseInt(b);
	}
	
	public int mul(String a, String b) {
		return Integer.parseInt(a)*Integer.parseInt(b);
	}
	
	public int div(String a, String b) {
		return Integer.parseInt(a)/Integer.parseInt(b);
	}

	public int all(String a, String b, String oper) {
		int res=0;
		int conA=Integer.parseInt(a);
		int conB=Integer.parseInt(b);
		
		if(oper.equals("calAdd")) {
			res=conA+conB;
		}
		else if(oper.equals("calSub")) {
			res=conA-conB;
		}
		else if(oper.equals("calMul")) {
			res=conA*conB;
		}
		else if(oper.equals("calDiv")) {
			res=conA/conB;
		}
		
		return res;
	}
}
