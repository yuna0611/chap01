package mms.member.dao;

import static mms.member.db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.vo.Member;

public class MemberDAO {
	Connection con;
	public MemberDAO(Connection con) {
		this.con=con;
	}
	
	public int insertNewMember(Member newMember) {
		int insertCount = 0;
		PreparedStatement pstmt = null;	//쿼리문 실행할 수 있는 객체
		String sql = "INSERT INTO member VALUES(member_id_seq.nextval,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);	//생성 방법
			pstmt.setString(1,newMember.getName());
			pstmt.setString(2,newMember.getAddr());
			pstmt.setString(3,newMember.getNation());
			pstmt.setString(4,newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return insertCount;
	}
	
	public ArrayList<Member> selectMemberList(){
		ArrayList<Member> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member";
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();	//sql이 select 일때는 query   //update,insert,delete 등 일때는 executeUpdate 사용
			memberList = new ArrayList<Member>();
			Member member = null;
			while(rs.next()) {	//튜플 하나씩 로딩해옴
				member = new Member(rs.getString("name"), rs.getString("addr"), rs.getString("nation"), rs.getString("email"), rs.getInt("age"));
				//레코드 하나 당 Member  객체 하나 씩 생성
				
				memberList.add(member);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return memberList;
	}
	
	
	
	public int updateMember(Member updateMember) {
		int updateCount = 0;
		PreparedStatement pstmt=null;
		String sql="UPDATE member SET addr=?, nation=?, email=?, age=? WHERE name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,updateMember.getAddr());
			pstmt.setString(2,updateMember.getNation());
			pstmt.setString(3,updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5,updateMember.getName());
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return updateCount;
	}
	
	
	public Member selectOldMember(String name) {
		Member oldMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				oldMember = new Member(rs.getString("name"), rs.getString("addr"), rs.getString("nation"), rs.getString("email"), rs.getInt("age"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return oldMember;
	}
	
	
	
	public int deleteMember(String name) {
		int deleteCount = 0;
		PreparedStatement pstmt=null;
		String sql="DELETE member WHERE name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return deleteCount;
	}
}
