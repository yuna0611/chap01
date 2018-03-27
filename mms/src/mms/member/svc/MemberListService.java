package mms.member.svc;

import java.sql.Connection;
import java.util.ArrayList;
import static mms.member.db.JdbcUtil.*;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberListService {
	public ArrayList<Member> getMemberList(){
		//트랜잭션 처리를 위해서 Connection 객체를 Service 클래스에서 생성
		//트렌젝션은 Connection 단위로 이루어지기 때문
		//만약, Service 클래스에서 정의한 메소드가 order 라면
		//order 메소드에서는 DAO 클래스를 생성할 때 Connection 객체를 초기화 한 후
		//동일한 Conneciton 객체를 사용해서 결제 테이블에 데이터를 삽입하는 처리를 하는
		//DAO 클래스의 메소드와 주문 테이블에 데이터를 삽입하는 메소드를 실행해야 하기 때문
		
		Connection con = getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		ArrayList<Member> memberList = memberDAO.selectMemberList();
		//Service 클래스의 메소드 명은 비지니스 적인 이름 사용
		//DAO클래스에서는 데이터와 관련된 작업이름 ( select, update, delete, insert) 등
		//을 사용해서 메소드 이름 지정
		close(con);
		return memberList;
	}
}
