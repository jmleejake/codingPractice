package algorithm;

public interface Questions {
	/**
	 * 1.정수를 입력 받아 1부터 해당 정수까지의 합계를 구한다
	 * @param to 입력한 숫자값 (까지)
	 * @return
	 */
	public int sumOneToInputNumber(int to);
	/**
	 * 2.정수를 2개 입력받아 각 숫자 사이의 합계를 구한다
	 * (예: 5,10 입력->5,6,7,8,9,10의 합계)
	 * @param from 입력한 숫자값 (부터)
	 * @param to 입력한 숫자값 (까지)
	 * @return
	 */
	public int sumInputNumbers(int from, int to);
	/**
	 * 3. 정수를 입력받아 3의 배수이면 3,5의배수면 5,
	 * 둘 모두의 배수면 35라고출력
	 * @param num 입력한 숫자값
	 * @return
	 */
	public String printThreeFive(int num);
	/**
	 * 4. 1,3,5,7,9,11,13,15,17,19 출력
	 * @return
	 */
	public String printOddNumbers();
	/**
	 * 5. 1,1,2,3,5,8,14,21,34,55 출력
	 * @return
	 */
	public String printFibonachi();
	/**
	 * 6. 배열에 정수 10개를 저장한후, Selection Sort하여 출력
	 * @param nums 정수 10개의 배열
	 * @return
	 */
	public String printSelectionSort(int[] nums);
	/**
	 * 7. 배열에 정수 10개를 저장한후, BubbleSort하여 출력
	 * @param nums 정수 10개의 배열
	 * @return
	 */
	public String printBubbleSort(int[] nums);
}
