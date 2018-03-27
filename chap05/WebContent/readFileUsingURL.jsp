<%@page import="java.io.*"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>기본 객체 사용하여 자원 읽기</title>
</head>
<body>

<%
	String resourcePath = "/notice.txt";
	char[] buff = new char[128];
	int len=-1;
	URL url=application.getResource(resourcePath);
	%>
	<%=url %>
	<br>
<%
	try(InputStreamReader br = new InputStreamReader(url.openStream(),"UTF-8")){
		while((len=br.read(buff))!=-1){
			out.print(new String(buff, 0, len));
		}
	}catch(IOException ex){
		out.println("익셉션 발생 : "+ex.getMessage());
	}
%>
</body>
</html>