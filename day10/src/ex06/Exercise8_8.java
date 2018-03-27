package ex06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise8_8 {

	public static void main(String[] args) {
		// 1~100 ������ ������ ���� �� answer�� �����Ѵ�.
		Scanner scanner = new Scanner(System.in);
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0; // ������Է��� ������ ����
		int count = 0; // �õ�Ƚ���� ���� ���� ����

		while (input!=answer) {
			count++;
			System.out.print("1�� 100 ������ ���� �Է��ϼ��� : ");
			
			try {
				input = scanner.nextInt();
				if (input < answer) {
					System.out.println("�� ū ���� �Է��ϼ���");
				} else if (input > answer) {
					System.out.println("�� ���� ���� �Է��ϼ���");
				} else if (input == answer) {
					System.out.println("****�����Դϴ�****");
					System.out.println("\""+count + "\" �� ���� ������ϴ�.");
				}
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է����ּ���");
				scanner = new Scanner(System.in);
				//input = scanner.nextInt();
			}
		}
	}
}
// end of class HighLow
