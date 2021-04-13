<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findId.jsp</title>
</head>
<body>
	<h1>이메일 찾기 화면</h1>
	<h1>/WEB-INF/views/login/findId.jsp</h1>
	<form action="/login/findIdResult" method="post">
		<input type="number" id="phonenumber" name="phonenumber">
		<input type="submit" value="이메일찾기">
	</form>
</body>
</html>