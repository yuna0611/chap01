<%@page import="guestbook.service.InvalidPasswordException"%>
<%@page import="guestbook.service.DeleteMessageSerivce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	int messageId = Integer.parseInt(request.getParameter("messageId"));
	String password = request.getParameter("password");
	boolean invalidPassword = false;
	try{
		DeleteMessageSerivce deleteService = DeleteMessageSerivce.getInstance();
		deleteService.deleteMessage(messageId, password);
	}catch(InvalidPasswordException ex){
		invalidPassword=true;
	}
%>
<html>
<head>
<meta hcontent="text/html; charset=UTF-8">
<title>방명록 메시지 삭제함</title>
</head>
<body>
	invalidPassword 값 : <%out.println(invalidPassword); %>
	<% if(!invalidPassword){ %>
	메시지를 삭제하였습니다.
	<% } else{ %>
	입력한 암호가 올바르지 않습니다. 암호를 확인해주세요.
	<% } %>
	</br>
	<a href="list.jsp">[목록 보기]</a>
</body>
</html>