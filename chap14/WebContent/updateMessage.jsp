<%@page import="guestbook.service.MessageNotFoundException"%>
<%@page import="guestbook.service.UpdateMessageSerivce"%>
<%@page import="guestbook.service.InvalidPasswordException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="message" class="guestbook.model.Message">
   <jsp:setProperty name="message" property="*" />
</jsp:useBean>   

<%
	boolean invalidPassword = false;
	boolean messageNotFound= false;
	
	try{
		UpdateMessageSerivce updateService = UpdateMessageSerivce.getInstance();
		updateService.updateMessage(message);
		}catch(InvalidPasswordException ex){
			invalidPassword=true;
		}catch(MessageNotFoundException ex){
			messageNotFound=true;
		}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 메시지 수정함</title>
</head>
<body>
		<% if(!invalidPassword && !messageNotFound){ %>
			메시지를 수정하였습니다.
		<% } else if(messageNotFound){ %>
			메시지가 존재하지 않거나 이미 삭제된 메시지 입니다.
		<% } else{%>
			입력한 암호가 올바르지 않습니다. 암호를 확인해주세요.
		<% }%>
		</br>
		<a href="list.jsp">[목록 보기]</a>
</body>
</html>