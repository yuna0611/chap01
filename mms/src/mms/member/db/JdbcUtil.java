package mms.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	static {
		//Ŭ������ �ε��� �� �� �ѹ� ȣ��Ǵ� ����
		//Classs.forName : Ư�� Ŭ������ �޸𸮷� �ε��ϴ� �޼ҵ�
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		//DB �۾��� �ʿ��� Connection ��ü�� ������ �ִ� �޼ҵ�
	Connection con = null;
	try {
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcla","tester2","1234");
		con.setAutoCommit(false);
		
		System.out.println("----���� ����----");
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	//transaction ó�� �޼ҵ�
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}