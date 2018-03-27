<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		border: 1px solid black;
		margin : 10px;
	}
</style>
</head>
<body>
	<center>
		<section id="uploadFormArea">
		<form action="fileUpload.jsp" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td colspan="2" class="td_title">파일 업로드 폼</td>
				<tr>
					<td><label for="name">올린 사람 : </label></td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td><label for="subject">제목 : </label></td>
					<td><input type="text" name="subject" id="subject"></td>
				</tr>
				<tr>
					<td><label for="fileName1">파일명1 : </label></td>
					<td><input type="file" name="fileName1" id="fileName1">
					</td>
				</tr>
				<tr>
					<td><label for="fileName2">파일명2 : </label></td>
					<td><input type="file" name="fileName2" id="fileName2">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="전송">
					</td>
				</tr>
			</table>
		</form>
		</section>
	</center>
</body>
</html>