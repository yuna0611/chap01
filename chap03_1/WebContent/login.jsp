<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String id=request.getParameter("memberId");
	if(id!=null && id.equals("madvirus")){
		response.sendRedirect("/chap03_1/index.jsp");
	}else{
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α��� ����</title>
</head>
<body>
�߸��� ���̵��Դϴ�.
</body>
</html>
<% 
	}
%>
