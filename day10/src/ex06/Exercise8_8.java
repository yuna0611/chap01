package ex06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise8_8 {

	public static void main(String[] args) {
		// 1~100 사이의 임이의 값을 얻어서 answer에 저장한다.
		Scanner scanner = new Scanner(System.in);
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0; // 사용자입력을 저장할 공간
		int count = 0; // 시도횟수를 세기 위한 변수

		while (input!=answer) {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요 : ");
			
			try {
				input = scanner.nextInt();
				if (input < answer) {
					System.out.println("더 큰 수를 입력하세요");
				} else if (input > answer) {
					System.out.println("더 작은 수를 입력하세요");
				} else if (input == answer) {
					System.out.println("****정답입니다****");
					System.out.println("\""+count + "\" 번 만에 맞췄습니다.");
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요");
				scanner = new Scanner(System.in);
				//input = scanner.nextInt();
			}
		}
	}
}
// end of class HighLow
