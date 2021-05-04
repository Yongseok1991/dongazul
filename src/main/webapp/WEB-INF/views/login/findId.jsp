<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아줄 : 이메일 찾기</title>
</head>
<body>
	<h1>이메일 찾기</h1>
	<h1>휴대폰 번호를 입력해주세요</h1>
	<form action="/login/findIdResult" method="post"> 
		<label for="phoneNumber">Phone-number: </label>
		<input type="number" id="phonenumber" name="phonenumber">
		<input type="submit" value="이메일찾기">
	</form>
</body>
</html>