<%@page import="guestbook.model.Message"%>
<%@page import="guestbook.service.UpdateMessageSerivce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int messageId = Integer.parseInt(request.getParameter("messageId"));
	UpdateMessageSerivce updateService = UpdateMessageSerivce.getInstance();	//아이디값을 통해서 데이터 가져오기 //싱글톤패턴
	Message message = updateService.updateMessage(messageId);	//updateMessage 메소드를 통해서 업데이트,, message 통해서 반환 
																//아이디값에 해당하는 정보 출력
%>
<!-- update == modifyForm -->
<c:set var="message" value="<%=message %>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 메시지 수정 확인</title>
</head>
<body>
<form action="updateMessage.jsp" method="post">
	이름 : <input type="text" name="guestName" value="${message.guestName}"><br>
	<input type="hidden" name="id" value=<%=request.getParameter("messageId") %>>
	암호 : <input type="password" name="password"><br>
	메시지 : <textarea name="message" rows="3" cols="30">${message.message}</textarea><br>
	<input type="submit" value="메시지 수정하기"/>	
	
					<!-- 수정하기 누르면 updateMessage.jsp로 이동 -->
</form>
</body>
</html>