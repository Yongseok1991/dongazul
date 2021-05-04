<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>findIdResult.jsp</title>
</head>
<body>
	<h1>이메일 찾기 결과</h1>

	이메일 : ${FIND} 
	<hr>
	<form action="/login/signIn" method="get">
		<input type="submit" value="Back to Login">
	</form>
</body>
</html>