package ch03_pjt_02;

public class CalDiv implements ICalculator{
	public int doOperation(int fnum, int snum) {
		return snum!=0 ? (fnum/snum) : 0;
	}

}
