<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   	Cookie[] cookies = request.getCookies();
  	String check="";
   	String id=request.getParameter("id");
   	if(cookies!=null){
   		for(int i=0; i<cookies.length; i++){
   			String cookie = cookies[i].getName();
   			if(cookies!=null && cookie.equals("check")){
   				check=cookies[i].getValue();	
   			}
   		}
   	}
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Login</title>
<style>
	#loginArea{
		width:400px;
		margin: auto;
		border: 1px solid black; 
	}
	table{
		margin: auto;
	}
	td{
		text-align: center;
	}
</style>
</head>
<body>
	<section id="loginArea">
	<form action="sessionLogin2.jsp" method="post">
		<table>
			<tr>
				<td><label for="id">아이디 : </label></td>
				<td><input type="text" name="id" id="id" value="<%=check %>"></td>
			</tr>
			<tr>
				<td><label for="pass">비밀번호 : </label></td>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인">
								<input type="reset" value="다시 작성">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="checkbox" name="check"			
						<%if(check!=null){ %> checked <%} %>>아이디 저장
				</td>
			</tr>
		</table>
	</form>
	</section>
		
</body>
</html>