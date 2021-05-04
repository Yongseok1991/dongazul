<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findPw.jsp</title>

<link rel="stylesheet" href="/resources/css/findPw.css">
</head>

<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script src="/resources/js/findPw.js"></script>

<body>
	<div class="wrap">
		<div class="box">
			<h1>비밀번호 찾기</h1>
			<form action="/login/findPwResult" method="post">
				<input type="text" id="email" placeholder="이메일 입력" name="email">
				<!-- <p>전화번호 입력</p>
				<input type="number" id="phonenumber" name="phonenumber"> -->
				<input type="submit" class="findPw" value="비밀번호 찾기">
			</form>

			<input type="submit" class="back" value="돌아가기" onclick="back()"></button>

		</div>
	</div>
</body>
</html>