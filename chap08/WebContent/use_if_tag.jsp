<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>if 태그</title>
</head>
<body>

<c:set var="name" value="bk"/>
<c:set var="age" value="27"/>
    	
<c:if test="true">
	무조건 수행<br>
</c:if>

<c:if test="${param.name=='bk' }">
name 파라미터의 값이 ${param.name } 입니다.<br>
</c:if>

<c:if test="${18<param.age }">
당신의 나이는 18세 이상입니다.
</c:if>
</body>
</html>