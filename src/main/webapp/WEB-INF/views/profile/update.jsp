<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>

                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <title>프로필 수정</title>
                
                <link rel="stylesheet" href="/resources/signUp.css">
            </head>

            <body>
               
                <section class="wrap">
 					 <div class="login">               	
                	<h2>Myprofile</h2>
                    <form action="/profile/update" method="POST">
                        <div class="form-group has-feedback">
                            <br>
                            <input class="form-control" name="email" type="hidden" value="${member.email}">
                        </div>
                        <div class="login_id">
                            <label class="control-label" for="nickname">NickName</label>
                            <br>
                            <input class="form-control" type="nickname" id="nickname" 
                                   name="nickname" value="${__PROFILE__.nickname}"
                                   placeholder="상대방에게 보여줄 닉네임을 정해주세요." />
                        </div>
                        <div class="login_id">
                            <label class="control-label" for="age">Age</label>
                            <br>
                            <input class="form-control" type="number" min=0 id="age" 
                                   name="age" value="${__PROFILE__.age}" placeholder="age" />
                       
                        </div>
                        
                        <div class="login_id">
                            <label class="control-label" for="gender">Gender</label>
                            <br>
                            <select name="gender" class="form-control" id="gender" value=>
                                <option value="M">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;M</option>
                                <option value="W">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;W</option>
                            </select>
                        </div>
                        
                        <div class="login_id">
                            <label class="control-label" for="zone">zone</label>
                            <br>
                            <input class="form-control" type="text" id="zone" 
                                   name="zone" value="${__PROFILE__.zone}" placeholder="사는곳을 적어주세요" />
                        </div>
                        
                        <div class="login_id">
                            <label class="control-label" for="introduce">Self-Introduction</label>
                            <br>
                            <textarea class="form-control" type="content" cols="50"
                            rows="8" id="introduce" name="introduce" value="${__PROFILE__.introduce}"
                            placeholder="자기소개를 작성해주세요."></textarea>
                            <div id=text_cnt>(0/500)</div>
                        </div>
                       

                        <div class="login_id">
                            <select name="hobby1" class="control-label">

                                <option value="">취미1
                                <option value="운동">운동
                                <option value="요리">요리
                                <option value="독서">독서
                                <option value="코딩">코딩
                                <option value="그림">그림
                                <option value="여행">여행
                                <option value="공예">공예
                                <option value="영화">영화
                                <option value="드라마">드라마
                                <option value="애니">애니
                            
                            </select>
                       
                       
                            <select name="hobby2" class="control-label">
                                
                                <option value="">취미2
                                <option value="운동">운동
                                <option value="요리">요리
                                <option value="독서">독서
                                <option value="코딩">코딩
                                <option value="그림">그림
                                <option value="여행">여행
                                <option value="공예">공예
                                <option value="영화">영화
                                <option value="드라마">드라마
                                <option value="애니">애니
                            
                            </select>

                       
                            <select name="hobby3" class="control-label">
                                
                                <option value="">취미3
                                <option value="운동">운동
                                <option value="요리">요리
                                <option value="독서">독서
                                <option value="코딩">코딩
                                <option value="그림">그림
                                <option value="여행">여행
                                <option value="공예">공예
                                <option value="영화">영화
                                <option value="드라마">드라마
                                <option value="애니">애니
                            
                            </select>
                        </div>

                        <div class="submit">
                            <button class="submit" type="submit" id="submit">Profile submit</button>
                        </div>
                    </form>
                    
                    <form action="/profile/info" method="get">
                    	<input type="hidden" name="email" value="${member.email}">
            			<input type="submit" value="←">
      			    </form>
                    </div>
                </section>
                
            </body>
            
            </html>