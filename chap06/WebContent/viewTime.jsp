<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>현재 시간</title>
</head>
<body>

<%
	Calendar cal = (Calendar)request.getAttribute("time");
%>

현재 시간은 <%= cal.get(Calendar.HOUR) %>시
		  <%= cal.get(Calendar.MINUTE) %>분
		  <%= cal.get(Calendar.SECOND) %>초 입니다.
</body>
</html>