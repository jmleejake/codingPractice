package algorithm;

public class Answer implements Questions {

	@Override
	public String printOddNumbers() {
		String ret = "";
		for(int i=1; i<20; i+=2) {
			ret += i+" ";
		}
		return ret;
	}

	@Override
	public String printFibonachi() {
		String ret = "";
		
		int no1 = 0;
		int no2 = 1;
		int sum = 0;
		
		ret = (no1+no2)+" ";
		for(int i=1; i<10; i++) {
			sum = no1 + no2;
			ret += sum+" ";
			no1 = no2;
			no2 = sum;
		}
		return ret;
	}

	@Override
	public String printSelectionSort(int[] nums) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printBubbleSort(int[] nums) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sumOneToInputNumber(int to) {
		int ret = 0;
		
		for(int i=1; i<=to; i++) {
			ret += i;
		}
		
		return ret;
	}

	@Override
	public int sumInputNumbers(int from, int to) {
		int ret = 0;
		
		for(int i=from; i<=to; i++) {
			ret += i;
		}
		
		return ret;
	}

	@Override
	public String printThreeFive(int num) {
		String ret = "아무것도 아님!";
		
		if(num % 3 == 0) {
			ret = "3";
		}
		
		if(num % 5 == 0) {
			ret = "5";
		}
		
		if(num % 3 == 0 && num % 5 == 0) {
			ret = "35";
		}
		
		return ret;
	}

}
