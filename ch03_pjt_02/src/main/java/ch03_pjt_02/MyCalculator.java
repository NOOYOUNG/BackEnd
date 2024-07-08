package ch03_pjt_02;

public class MyCalculator {
	public void calculate(int fnum, int snum, ICalculator calculator) {
		int value=calculator.doOperation(fnum, snum);
		System.out.println("result: "+value);
	}
}
