<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% session.setAttribute("id", request.getParameter("id")); %>
  <%
   /*  	Cookie cookie = new Cookie("id",request.getParameter("id"));
    	cookie.setMaxAge(0);
    	response.addCookie(cookie); */
    	String check = request.getParameter("check");
    	if(	check!=null){
    		Cookie cookie1 = new Cookie("check",request.getParameter("id"));
        	cookie1.setMaxAge(60*60);
        	response.addCookie(cookie1);
    	}else{
    	/* 	cookie1==null; */
    	}
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Login</title>
</head>
<body>
	<h3>로그인되었습니다.</h3>
	<h3>로그인 아이디 : <%=(String)session.getAttribute("id") %></h3>
	<a href="sessionLogout.jsp">로그아웃</a>
</body>
</html>