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
			System.out.println("아르고리즈무!!!");
			System.out.println("1.정수를 입력 받아 1부터 해당 정수까지의 합계를 구한다");
			System.out.println("2.정수를 2개 입력받아 각 숫자 사이의 합계를 구한다");
			System.out.println("3. 정수를 입력받아 3의 배수이면 3,5의배수면 5, 둘 모두의 배수면 35라고출력");
			System.out.println("4. 1,3,5,7,9,11,13,15,17,19 출력");
			System.out.println("5. 1,1,2,3,5,8,14,21,34,55 출력 (피보나치)");
			System.out.println("6. 배열에 정수 10개를 저장한후, Selection Sort하여 출력");
			System.out.println("7. 배열에 정수 10개를 저장한후, BubbleSort하여 출력");
			System.out.println("======================================================");
			System.out.println("문제선택!! > ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("1.정수를 입력 받아 1부터 해당 정수까지의 합계를 구한다");
				System.out.println("숫자입력!! > ");
				to = sc.nextInt();
				answer = ans.sumOneToInputNumber(to)+"";
				break;
			case 2:
				System.out.println("2.정수를 2개 입력받아 각 숫자 사이의 합계를 구한다");
				while(true) {
					System.out.println("숫자1 입력!! > ");
					from = sc.nextInt();
					System.out.println("숫자2 입력!! > ");
					to = sc.nextInt();
					
					if(from > to) {
						System.err.println("숫자1보다 2가 커야합니다!!");
					} else if(from == to) {
						System.err.println("숫자1과 2가 같을수없습니다!!");
					} else {
						break;
					}
				}
				answer = ans.sumInputNumbers(from,to)+"";
				break;
			case 3:
				System.out.println("3. 정수를 입력받아 3의 배수이면 3,5의배수면 5, 둘 모두의 배수면 35라고출력");
				System.out.println("숫자입력!! > ");
				to = sc.nextInt();
				answer = ans.printThreeFive(to);
				break;
			case 4:
				System.out.println("4. 1,3,5,7,9,11,13,15,17,19 출력");
				answer = ans.printOddNumbers();
				break;
			case 5:
				System.out.println("5. 1,1,2,3,5,8,14,21,34,55 출력 (피보나치)");
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
				System.err.println("이상한 숫자는 다메!!");
				break;
			}
			System.out.println("***********************");
			System.out.println(String.format("The answer is!!! >>> %s", answer));
			System.out.println("***********************");
		}
		
		
	}

}
