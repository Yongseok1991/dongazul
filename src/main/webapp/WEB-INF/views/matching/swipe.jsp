<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Insert title here</title>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.3.2/jquery-migrate.min.js"></script>
<link rel="stylesheet" href="/resources/css/swipe.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

<style>
	.thumbImg {
	}

</style>

<!--fontawesome ---->
<script src="https://kit.fontawesome.com/dc299fac74.js" crossorigin="anonymous"></script>

</head>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#signOut").on("click", function(){
				location.href="/login/signOut";
			})
			
		$("#memberUpdateBtn").on("click", function(){
			location.href="/member/changePw";
		})
		
		var msg = '${msg}';
        if (msg.length > 0) {
            alert(msg);
        }		
	})
	</script>
<body>
	
		<nav class="navbar">
        <a class="fas fa-fire" href="#"></a> <!-- 누르기 기능 삭제 -->
		<a class="fas fa-comments" href="/chat/rooms"></a>
        <a class="fas fa-user" href="/profile/info?email=${member.email}"></a>
    </nav>

    <div class="photo-and-actions">
        <div class="photo"> <!-- css image에다가 pl태그달기 -->
            <div class="photo-text">
                <div class="photo-name-and-age">
                    <h2>Lorem</h2>
                    <h2>21</h2>
                </div>
                <div class="photo-bio">
                    <h1>/WEB-INF/views/swipe.jsp</h1>
					
					<div>
						<!-- 관심사 넣어주기 -->
						체크드박스로 자기 관심사 만들어 넣어줘야함 
					</div>
				</div>
            </div>
        </div>


        <div class="actions">
            <div class="action">
                <a class="fas fa-times"></a>
            </div>

            <div class="action">
                <a class="fas fa-star"></a>
            </div>

            <div class="action">
                <a class="fas fa-heart"></a>
            </div>
        </div>
    </div>
		
	<c:if test="${member != null}">
        <div>
            <p>${member.email}님 환영합니다.</p>
     <button id="memberUpdateBtn" type="button">회원정보수정</button>
     <button id="signOut" type="button">로그아웃</button>
     </div>
     </c:if>
     
     
	 
     
    
     
</body>
</html>