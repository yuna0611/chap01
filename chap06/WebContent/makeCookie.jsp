<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Cookie cookie = new Cookie("name", URLEncoder.encode("최범균","utf-8"));
    	response.addCookie(cookie);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 생성</title>
</head>
<body>
	<%=cookie.getName() %>쿠키의 값="<%= cookie.getValue() %>"
</body>
</html>