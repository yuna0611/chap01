<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이름 변경폼</title>
</head>
<body>
<form action="inserttest2.jsp" method="post">
	<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="memberID" size="20"></td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="password" name="password" size="20"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" size="20"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email" size="20"></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="삽입">
		</td>
	</tr>
	</table>
</form>
</body>
</html>