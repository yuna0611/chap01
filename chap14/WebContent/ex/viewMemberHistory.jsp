<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.Reader"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String memberID = request.getParameter("memberID");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>
<%
		/* Class.forName("com.mysql.jdbc.Driver"); */
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try{
    		/* String jdbcDriver = "jdbc:mysql://localhost:3306/chap14?"+
    							"useUnicde=true&characterEncoding=utf8"; */
    		String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:orcla";
    		String dbUser = "jspexam";
    		String dbPass = "jsppw";
    		
    	 	String query = "select * from MEMBER where memberid='"+memberID+"'";
			
			conn=DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
    		stmt=conn.createStatement();
    		rs=stmt.executeQuery(query);
    		if(rs.next()){
%>
		<table border="1">
			<tr>
				<td>아이디</td><td><%=memberID %></td>
			</tr>
			<tr>
				<td>히스토리</td>
				<td>
			<%
				/* String history = rs.getString("history"); */
				String history=null;
				Reader reader =null;
				try{
					reader=rs.getCharacterStream("HISTORY");
					
					if(reader!=null){
						StringBuilder buff = new StringBuilder();
						char[] ch = new char[512];
						int len=-1;
						
						while((len=reader.read(ch))!=-1){
							buff.append(ch,0,len);
						}
						history = buff.toString();
					}
				}catch(IOException ex){
					out.println("익셉션 발생:"+ex.getMessage());
				}finally{
					if(reader!=null)
						try{
							reader.close();
						}catch(IOException ex){}
				}
			%>
				<%=history %>
			</td>
			</tr>
		</table>
		<%
    		}else{
		%>
		<%=memberID %> 회원의 히스토리가 없습니다.
		<%
    		}
    	}catch(SQLException ex){
		%>
		에러 발생 : <%=ex.getMessage() %>
		<%
    	}finally{
    		if(rs!=null)
				try{
					rs.close();
				}catch(SQLException ex){}
			if(stmt!=null)
				try{
					stmt.close();
				}catch(SQLException ex){}
			
			//7. 커넥션 종료
			if(conn!=null)
				try{
					conn.close();
				}catch(SQLException ex){}
    	}
		%>
</body>
</html>