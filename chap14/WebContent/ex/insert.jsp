<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
    	request.setCharacterEncoding("utf-8");
    
    	String memberID = request.getParameter("memberID");
    	String pw = request.getParameter("password");
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	int updateCount=0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트추가</title>
</head>
<body>
    <%
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try{
    		String jdbcDriver = "jdbc:mysql://localhost:3306/chap14?"+
    							"useUnicde=true&characterEncoding=utf8";
    		String dbUser = "jspexam";
    		String dbPass = "jsppw";
    		
    	 	String query = "insert into MEMBER values('"+memberID+"','"+pw+"','"+name+"','"+email+"')";
			String query1 ="select * from MEMBER order by MEMBERID";
			
			conn=DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
    		stmt=conn.createStatement();
    		updateCount=stmt.executeUpdate(query);
    		rs=stmt.executeQuery(query1);
    	%>
    	<table width="100%" border="1">
			<tr>
				<th>아이디</th>
				<th>암호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
    	<%
			while(rs.next()){
		%>
			<tr>
			<td><%=rs.getString("MEMBERID") %></td>
				<td><%=rs.getString("PASSWORD") %></td>
				<td><%=rs.getString("NAME") %></td>
				<td><%=rs.getString("EMAIL") %></td>
			</tr>
		<%
					}
    	}finally{
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
<%-- 
<table border="1">
		<tr>
			<td>이름</td>
			<td><%=memberID %></td>
		</tr>
			<td>암호</td>
			<td><%=pw%></td>
		<tr>
		</tr>
			<td>이름</td>
			<td><%=name %></td>
		<tr>
		</tr>
			<td>이메일</td>
			<td><%=email %></td>
		<tr>
	</table>
	 --%>
</table>
</body>
</html>