package mms.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import mms.member.svc.MemberListService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberListAction implements Action{

	@Override
	public void execute(Scanner sc){
		// TODO Auto-generated method stub
		ConsoleUtil cu = new ConsoleUtil();
		
		//��2 ���߹�Ŀ����� �������� �����������(������� ��û�� ó���ϴ� ����, �α���ó��, ȸ��
		//��  Service Ŭ�������� ó��
		
		MemberListService memberListService = new MemberListService();
		
		//Service Ŭ���� ������ ȸ���� ����� ȣ���ϴ� �κ�
		ArrayList<Member> memberList = memberListService.getMemberList();
		
		cu.printMemberList(memberList);
	}
	
}
