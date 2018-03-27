package mms.member.util;

import java.util.ArrayList;
import java.util.Scanner;
import mms.member.vo.Member;

public class ConsoleUtil {
	public Member getNewMember(Scanner sc) {
		System.out.println("����� ȸ�� ������ �Է��ϼ��� ");
		System.out.println("�̸�  : ");
		String name = sc.next();
		
		System.out.println("�ּ� : ");
		String addr = sc.next();

		
		System.out.println("���� : ");
		String nation = sc.next();

		System.out.println("�̸��� : ");
		String email = sc.next();
		
		System.out.println("���� : ");
		int age = sc.nextInt();
		
		return new Member(name, addr, nation, email, age);
	}
	
	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + "ȸ�� ���� �߰� ����");
	}
	
	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + "ȸ�� ���� �߰� ����");
	}
	
	public void printMemberList(ArrayList<Member> memberList) {
		//size() : �÷��ǿ� ����Ǿ� �ִ� ����� ������ �����ϴ� �޼ҵ�
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println(memberList.get(i));
			//�ڹٿ��� ��ü�� + ������ �̷�� ���ų� ��ü�� print �޼ҵ��� �Ķ���ͷ� �����Ǹ�
			//�ش� ��ü�� toString() �޼ҵ尡 �ڵ����� ȣ��
		}
	}
	
	public Member getUpdateMember(Scanner sc, Member oldMember) {
		System.out.println("������ ȸ�� ������ �Է��ϼ���");
		System.out.println("���� ���� : "+oldMember.getNation());
		System.out.println("������ ���� : ");
		String nation = sc.next();
		
		System.out.println("���� �ּ� : "+oldMember.getAddr());
		System.out.println("������ �ּ� : ");
		String addr = sc.next();
		
		System.out.println("���� �̸��� : "+oldMember.getEmail());
		System.out.println("������ ���� : ");
		String email = sc.next();

		System.out.println("���� ����: "+oldMember.getAge());
		System.out.println("������ ���� : ");
		int age = sc.nextInt();
		
		return new Member(oldMember.getName(), addr, nation, email, age);
	}
	
	public String getName(String msgKind, Scanner sc) {
		System.out.println(msgKind+"ȸ���̸��� �Է��ϼ���");
		System.out.println("ȸ�� �̸� : ");
		return sc.next();
	}
	
	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + "ȸ�� ���� ���� ����");
	}
	public void printModifyFailMesaage(Member updateMember) {
		System.out.println(updateMember.getName() + "ȸ�� ���� ���� ����");
	}
	
	public void printRemoveSuccessMessage(String name) {
		System.out.println(name + "ȸ�� ���� ���� ����");
	}
	public void printRemoveFailMessage(String name) {
		System.out.println(name + "ȸ�� ���� ���� ����");
	}
}
