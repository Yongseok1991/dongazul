<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>

<!--fontawesome ---->
<script src="https://kit.fontawesome.com/dc299fac74.js" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.3.2/jquery-migrate.min.js"></script>

<link rel="stylesheet" href="/resources/css/info.css">

</head>

<body>

    <div id="wrapper"> 

        <nav class="navbar">
            <a class="fas fa-fire" href="#"></a> <!-- 누르기 기능 삭제 -->
            <a class="fas fa-comments" href="/chat/rooms"></a>
            <a class="fas fa-user" href="/profile/info"></a>
        </nav>

        <div class="profile-main">
            <div class="photo-name">
                <div class="photo-pro">
                    <img src="http://www.newsworks.co.kr/news/photo/202011/500020_390256_4135.jpg" alt="img1" class="img1">
                </div>
                <h1 class="values">
                    ${__PROFILE__.nickname}, &nbsp;<span>${__PROFILE__.age}</span>
                </h1>
                
                <h3>좋아요</h3>
            </div>

        </div>
        <div class="setting">
            <div class="set">
                <!-- a를 원래 버튼으로 기능 넣어줘야함 -->
                <a href="#" class="fas fa-cog fasrow"></a>
                <p>설정</p>

            </div>
            <div class="set">
                <a href="/profile/update?email=${member.email}" class="fas fa-id-card fasrow profile-up"></a>
                <p>프로필 수정</p>
            </div>
            <div class="set">
                <a href="/profile/create" class="fas fa-camera fasrow"></a>
                <p>미디어 추가</p>
            </div>
        </div>

        <form action="/matching/swipe" method="get">
            <input type="submit" value="←">
        </form>
        
    </div>  

</body>
</html>