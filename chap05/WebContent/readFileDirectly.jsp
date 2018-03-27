<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	char[] buff = new char[128];
	int len=-1;
	
	String filePath="C:\\yuna\\workspace\\chap05\\WebContent\\notice.txt";
	try(InputStreamReader fr = new InputStreamReader(new FileInputStream(filePath),"UTF-8")){
			while((len=fr.read(buff))!=-1){
				out.print(new String(buff, 0, len));
			}
		}catch(IOException ex){
			out.println("익셉션 발생 : "+ex.getMessage());
		}
%>
</body>
</html>