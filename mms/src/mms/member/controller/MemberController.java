package mms.member.controller;

import java.util.Scanner;

import mms.member.action.Action;

public class MemberController {	//��û�� ����� �Ǵ��ؼ� �� ����� �����ϰ� ����
	public void processRequest(Action action, Scanner sc){
		try {
			action.execute(sc);
			//�������̽��� ���۷��� ������ �������̽��� ������ Ŭ���� ��ü�� �����ϸ�
			//�������̽��� ���ǵ� �޼ҵ带 ȣ���ϸ� ���������� �� Ŭ�������� ������ �޼ҵ尡 ȣ��ȴ�.
		} catch (Exception e) {
			e.printStackTrace();
			//e.printSctackTrace() : ���� Ŭ�������� �����Ǵ� �޼ҵ� �̸� ���ÿ� ����Ǿ� �ִ� 
			//�޼ҵ� ȣ�� ����� �����ϴ� �޼ҵ�
			//�ַ� ������ ����.
		}
	}
}
