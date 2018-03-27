<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	form{
		border: 1px solid red;
		margin: 0 auto; 
		padding : 10px;
        width:550px;
	}
	input{
		margin:5px;
	}
</style>
</head>
<body>
	<center><h1>회원 가입 양식</h1></center>
	<form>
	
		<label>이름</label>
			 <input type="text"><br>
		<label for="mf">성별</label>
			남<input type="radio" id="mf" value="남"> 여<input type="radio" id="mf" value="여"><br>
		<label for="hobby">취미</label>
			<input type="checkbox" id="hobby" value="독서">독서
			<input type="checkbox" id="hobby" value="게임">게임
			<input type="checkbox" id="hobby" value="TV시청">TV시청
			<input type="checkbox" id="hobby" value="축구">축구
			<input type="checkbox" id="hobby" value="기타" ">기타<br>
		<center><input type="submit" value="전송" ></center>
	</form>
</body>
</html>