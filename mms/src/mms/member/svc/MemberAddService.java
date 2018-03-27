package mms.member.svc;

import java.sql.Connection;
import static mms.member.db.JdbcUtil.*;	//앞에 class 안붙여도 쓸수있음.(static)
import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

//트렌젝션 처리는 비지니스 단에서 해주는 것이 Convention 이다.
//즉, Connection 객체는 비지니스 단에서 생성해서 사용하는 것이 일반적이다.


public class MemberAddService {
	public boolean addMember(Member newMember) throws Exception{
		boolean isInsertSuccess = false;
		Connection con = getConnection();	//DB 정보 가져옴
		MemberDAO memberDAO = new MemberDAO(con);	//DB 정보 넘겨줌
		
		int insertCount=memberDAO.insertNewMember(newMember);
		//insertCount : insert 작업이 수행된 후 반환되는 행 수
		if(insertCount>0) {
			commit(con);	//jdbcUtil 로 데이터가 넘어감
			isInsertSuccess=true;
		}else {
			rollback(con);
		}
		
		close(con);
		return isInsertSuccess;
	}
}
