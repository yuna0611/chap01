<%@ page import="guestbook.model.Message" %>
<%@page import="guestbook.service.MessageListView"%>
<%@page import="guestbook.service.GetMessageListService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String pageNumberStr = request.getParameter("page");
    int pageNumber =1;
    if(pageNumberStr!=null){
    	pageNumber = Integer.parseInt(pageNumberStr);
    }
    
    GetMessageListService messageListService = GetMessageListService.getInstance();
    MessageListView viewData = messageListService.getMessageList(pageNumber);
%>

<c:set var="viewData" value="<%=viewData %>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 메세지 목록</title>
</head>
<body>

<form action="writeMessage.jsp" method="post">
	이름 : <input type="text" name="guestName"> <br>
	암호 : <input type="password" name="password"> <br>
	메시지 : <textarea name="message" rows="3" cols="30"></textarea> <br>
	<input type="submit" value="메시지 남기기" />
</form>

<hr>
	<c:if test="${viewData.isEmpty()}">
	등록된 메시지가 없습니다.
	</c:if>
	
	<c:if test="${!viewData.isEmpty() }">
		<table border="1">
			<c:forEach var="message" items="${viewData.messageList}">
			<tr>
				<td>
				메시지 번호 : ${message.id }<br/>
				손님 이름 : ${message.guestName }<br/>
				메시지 : ${message.message }<br/>
				비번 : ${message.password }<br/>
				<a href="confirmDeletion.jsp?messageId=${message.id}">[삭제하기]</a>
				<a href="confirmUpdate.jsp?messageId=${message.id}">[수정하기]</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
		<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount }">
			<a href="list.jsp?page=${pageNum}">[${pageNum }]</a>
		</c:forEach>
	</c:if>
</body>
</html>