package mms.member.svc;

import java.sql.Connection;
import java.util.ArrayList;
import static mms.member.db.JdbcUtil.*;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberListService {
	public ArrayList<Member> getMemberList(){
		//Ʈ����� ó���� ���ؼ� Connection ��ü�� Service Ŭ�������� ����
		//Ʈ�������� Connection ������ �̷������ ����
		//����, Service Ŭ�������� ������ �޼ҵ尡 order ���
		//order �޼ҵ忡���� DAO Ŭ������ ������ �� Connection ��ü�� �ʱ�ȭ �� ��
		//������ Conneciton ��ü�� ����ؼ� ���� ���̺� �����͸� �����ϴ� ó���� �ϴ�
		//DAO Ŭ������ �޼ҵ�� �ֹ� ���̺� �����͸� �����ϴ� �޼ҵ带 �����ؾ� �ϱ� ����
		
		Connection con = getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		ArrayList<Member> memberList = memberDAO.selectMemberList();
		//Service Ŭ������ �޼ҵ� ���� �����Ͻ� ���� �̸� ���
		//DAOŬ���������� �����Ϳ� ���õ� �۾��̸� ( select, update, delete, insert) ��
		//�� ����ؼ� �޼ҵ� �̸� ����
		close(con);
		return memberList;
	}
}
