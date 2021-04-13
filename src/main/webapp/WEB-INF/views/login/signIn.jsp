<%@page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>signIn.jsp</title>


</head>

<script type="text/javascript">
$("#registerBtn").on("click", function(){
	location.href="/member/signUp";
})
</script>
<body>
    <form action="/login/signIn" method="POST">
        <c:if test="${number == null}">
    	<div>
        <label for="email">1. 아이디</label>
	    <input type="text" id="email" name="email"><br>
	   </div>
	   <div>
        <label for="passwd">2. 비밀번호</label>
        <input type="password" id="passwd" name="passwd"><br>
      </div>
      <div>
        <label for="rememberMe">3. rememberMe</label>
        <input type="radio" name="rememberMe"><br>
       </div>
       <div> 
        <input type="submit" value="로그인" >
       </div> 
        
    </c:if>
    <div> 
        <button id="registerBtn" type="button">회원가입</button>
       </div> 
    
    <c:if test= "${msg == false}">
        <p>로그인 실패 아이디와 비밀번호를 확인해주세요</p>
    </c:if>
 
     
    </form>
</body>
</html>