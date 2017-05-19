package algorithm;

public interface Questions {
	/**
	 * 1.������ �Է� �޾� 1���� �ش� ���������� �հ踦 ���Ѵ�
	 * @param to �Է��� ���ڰ� (����)
	 * @return
	 */
	public int sumOneToInputNumber(int to);
	/**
	 * 2.������ 2�� �Է¹޾� �� ���� ������ �հ踦 ���Ѵ�
	 * (��: 5,10 �Է�->5,6,7,8,9,10�� �հ�)
	 * @param from �Է��� ���ڰ� (����)
	 * @param to �Է��� ���ڰ� (����)
	 * @return
	 */
	public int sumInputNumbers(int from, int to);
	/**
	 * 3. ������ �Է¹޾� 3�� ����̸� 3,5�ǹ���� 5,
	 * �� ����� ����� 35������
	 * @param num �Է��� ���ڰ�
	 * @return
	 */
	public String printThreeFive(int num);
	/**
	 * 4. 1,3,5,7,9,11,13,15,17,19 ���
	 * @return
	 */
	public String printOddNumbers();
	/**
	 * 5. 1,1,2,3,5,8,14,21,34,55 ���
	 * @return
	 */
	public String printFibonachi();
	/**
	 * 6. �迭�� ���� 10���� ��������, Selection Sort�Ͽ� ���
	 * @param nums ���� 10���� �迭
	 * @return
	 */
	public String printSelectionSort(int[] nums);
	/**
	 * 7. �迭�� ���� 10���� ��������, BubbleSort�Ͽ� ���
	 * @param nums ���� 10���� �迭
	 * @return
	 */
	public String printBubbleSort(int[] nums);
}
