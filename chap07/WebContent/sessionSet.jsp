<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	session.setAttribute("name", "Session Test!");
	session.setAttribute("age", "100"); %>
<script>
	location.href="sessionTest.jsp";
</script>    
