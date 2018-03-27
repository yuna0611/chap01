package mms.member.svc;

import static mms.member.db.JdbcUtil.close;
import static mms.member.db.JdbcUtil.commit;
import static mms.member.db.JdbcUtil.getConnection;
import static mms.member.db.JdbcUtil.rollback;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberModifyService {

	public Member getOldMember(String name) {
		Member oldMember = null;
		Connection con = getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		oldMember = memberDAO.selectOldMember(name);
		close(con);
		return oldMember;
	}
	
	public boolean modifyMember(Member updateMember) {
		boolean isModifySuccess=false;
		Connection con = getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		int updateCount = memberDAO.updateMember(updateMember);
		if(updateCount>0) {
			isModifySuccess=true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return isModifySuccess;
	}
}
