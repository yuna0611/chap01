<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String resourcePath="/notice.txt";
	%>
	�ڿ��� ���� ���:<br>
	<%= application.getRealPath(resourcePath) %>
	<br>
	----------<br>
	<%= resourcePath %>�� ����<br>
	----------<br>
	<%
	char[] buff = new char[128];
	int len=-1;
	
	try(InputStreamReader br = new InputStreamReader(application.getResourceAsStream(resourcePath),"UTF-8")){
			while((len=br.read(buff))!=-1){
				out.print(new String(buff, 0, len));
			}
		}catch(IOException ex){
			out.println("�ͼ��� �߻� : "+ex.getMessage());
		}
%>
</body>
</html>