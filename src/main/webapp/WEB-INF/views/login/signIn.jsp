<%@page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>signIn.jsp</title>
</head>
<body>
    <form action="/matching/swipe" method="GET">
    	1. 아이디
	    <input type="text" id="id" name="id"><br>
	    2. 비밀번호
        <input type="password" id="passwd" name="passwd"><br>
        3. rememberMe
        <input type="radio" name="rememberMes"><br>
        <input type="submit" value="로그인" >
    </form>
</body>
</html>