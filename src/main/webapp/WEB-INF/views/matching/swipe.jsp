<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Insert title here</title>
</head>
<body>
	<h1>/WEB-INF/views/swipe.jsp</h1>
	<c:if test="${member != null}">
        <div>
            <p>${member.email}님 환영합니다.</p>
     </div>
     <button id=signOut type="button">로그아웃</button>
     </c:if>
     
     <c:if test= "${msg == false}">
        <p>로그인 실패 아이디와 비밀번호를 확인해주세요</p>
    </c:if>
    
     
</body>
</html>