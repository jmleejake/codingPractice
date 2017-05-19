package algorithm;

import java.util.Scanner;

public class AlgorithmMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Answer ans = new Answer();
		
		int from = 0;
		int to = 0;
		
		String answer = null;
		
		boolean exit = false;
		while(!exit) {
			System.out.println("======================================================");
			System.out.println("�Ƹ����!!!");
			System.out.println("1.������ �Է� �޾� 1���� �ش� ���������� �հ踦 ���Ѵ�");
			System.out.println("2.������ 2�� �Է¹޾� �� ���� ������ �հ踦 ���Ѵ�");
			System.out.println("3. ������ �Է¹޾� 3�� ����̸� 3,5�ǹ���� 5, �� ����� ����� 35������");
			System.out.println("4. 1,3,5,7,9,11,13,15,17,19 ���");
			System.out.println("5. 1,1,2,3,5,8,14,21,34,55 ��� (�Ǻ���ġ)");
			System.out.println("6. �迭�� ���� 10���� ��������, Selection Sort�Ͽ� ���");
			System.out.println("7. �迭�� ���� 10���� ��������, BubbleSort�Ͽ� ���");
			System.out.println("======================================================");
			System.out.println("��������!! > ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("1.������ �Է� �޾� 1���� �ش� ���������� �հ踦 ���Ѵ�");
				System.out.println("�����Է�!! > ");
				to = sc.nextInt();
				answer = ans.sumOneToInputNumber(to)+"";
				break;
			case 2:
				System.out.println("2.������ 2�� �Է¹޾� �� ���� ������ �հ踦 ���Ѵ�");
				while(true) {
					System.out.println("����1 �Է�!! > ");
					from = sc.nextInt();
					System.out.println("����2 �Է�!! > ");
					to = sc.nextInt();
					
					if(from > to) {
						System.err.println("����1���� 2�� Ŀ���մϴ�!!");
					} else if(from == to) {
						System.err.println("����1�� 2�� �����������ϴ�!!");
					} else {
						break;
					}
				}
				answer = ans.sumInputNumbers(from,to)+"";
				break;
			case 3:
				System.out.println("3. ������ �Է¹޾� 3�� ����̸� 3,5�ǹ���� 5, �� ����� ����� 35������");
				System.out.println("�����Է�!! > ");
				to = sc.nextInt();
				answer = ans.printThreeFive(to);
				break;
			case 4:
				System.out.println("4. 1,3,5,7,9,11,13,15,17,19 ���");
				answer = ans.printOddNumbers();
				break;
			case 5:
				System.out.println("5. 1,1,2,3,5,8,14,21,34,55 ��� (�Ǻ���ġ)");
				answer = ans.printFibonachi();
				break;
			case 6:
				
				break;
			case 7:
				
				break;
				
			case 99:
				exit = true;
				break;
			default:
				System.err.println("�̻��� ���ڴ� �ٸ�!!");
				break;
			}
			System.out.println("***********************");
			System.out.println(String.format("The answer is!!! >>> %s", answer));
			System.out.println("***********************");
		}
		
		
	}

}
