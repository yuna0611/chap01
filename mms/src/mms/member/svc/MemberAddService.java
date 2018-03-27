package mms.member.svc;

import java.sql.Connection;
import static mms.member.db.JdbcUtil.*;	//�տ� class �Ⱥٿ��� ��������.(static)
import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

//Ʈ������ ó���� �����Ͻ� �ܿ��� ���ִ� ���� Convention �̴�.
//��, Connection ��ü�� �����Ͻ� �ܿ��� �����ؼ� ����ϴ� ���� �Ϲ����̴�.


public class MemberAddService {
	public boolean addMember(Member newMember) throws Exception{
		boolean isInsertSuccess = false;
		Connection con = getConnection();	//DB ���� ������
		MemberDAO memberDAO = new MemberDAO(con);	//DB ���� �Ѱ���
		
		int insertCount=memberDAO.insertNewMember(newMember);
		//insertCount : insert �۾��� ����� �� ��ȯ�Ǵ� �� ��
		if(insertCount>0) {
			commit(con);	//jdbcUtil �� �����Ͱ� �Ѿ
			isInsertSuccess=true;
		}else {
			rollback(con);
		}
		
		close(con);
		return isInsertSuccess;
	}
}
