package mms.member.ui;

import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.action.MemberListAction;
import mms.member.action.MemberModifyAction;
import mms.member.action.MemberRemoveAction;
import mms.member.controller.MemberController;

public class MemberUI {
	public static void main(String[] args) {
		boolean isStop = false;
		MemberController memberController = new MemberController();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=====ȸ������ ���α׷�=====");
			System.out.println("1.ȸ�����");
			System.out.println("2.ȸ����Ϻ���");
			System.out.println("3.ȸ����������");
			System.out.println("4.ȸ����������");
			System.out.println("5.���α׷�����");
			System.out.println("6.�޴���ȣ:");
			int menu = sc.nextInt();
			Action action = null;

			switch (menu) {
			case 1:
				action = new MemberAddAction();
				break;
			case 2:
				action = new MemberListAction();
				break;
			case 3:
				action = new MemberModifyAction();
				break;
			case 4:
				action = new MemberRemoveAction();
				break;
			case 5:
				System.out.println("���α׷� ����");
				isStop = true;
				break;
			default:
				break;
			}
			if (action != null) {
				memberController.processRequest(action, sc);
			}
		} while (!isStop);
	}
}