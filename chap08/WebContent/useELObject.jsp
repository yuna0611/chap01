<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setAttribute("name", "최범균");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Object</title>
</head>
<body>
	요청 URI : ${pageContext.request.requestURI}<br>
	request의 name 속성 : ${name}<br>
	code 파라미터 : ${param.code}
</body>
</html>