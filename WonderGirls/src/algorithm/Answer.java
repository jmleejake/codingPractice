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
		int num = 1;
		int sum = 0;
		for(int i=1; i<9; i++) {
		}
		return null;
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
		String ret = "�ƹ��͵� �ƴ�!";
		
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
