<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>

                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <title>회원가입</title>
            </head>

            <link rel="stylesheet" href="css/create.css">

            <body>
                <div class="background"></div>
                <section id="container">
                    <form action="/member/register" method="post">
                        <div class="form-group has-feedback">
                            <label class="control-label" for="email">이메일주소</label>
                            <br>
                            <input class="form-control" type="email" id="email" name="email"
                            placeholder="@를 입력해주세요 " />
                        </div>
                        <div class="form-group has-feedback">
                            <label class="control-label" for="nickname">닉네임</label>
                            <br>
                            <input class="form-control" type="nickname" id="nickname" name="nickname"
                            placeholder="상대방에게 보여줄 닉네임을 정해주세요." />
                        </div>
                        <div class="form-group has-feedback">
                            <label class="control-label" for="age">나이</label>
                            <br>
                            <input class="form-control" type="number" min=0 id="age" name="age"
                            placeholder="나이를 '솔직하게' 적어주세요." />
                            <span id="chkNotice"></span>
                        </div>
                        
                        <div class="form-group has-feedback">
                            <label class="control-label" for="gender">성별</label>
                            <br>
                            <select name="gender" class="form-control" id="gender">
                                <option value="남">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;남성</option>
                                <option value="여">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;여성</option>
                            </select>
                        </div>
                        
                        <div class="form-group has-feedback">
                            <label class="control-label" for="zone">지역</label>
                            <br>
                            <input class="form-control" type="text" id="zone" name="zone"
                            placeholder="사는곳을 적어주세요" />
                        </div>
                        
                        <div class="form-group has-feedback">
                            <label class="control-label" for="introduce">자신을 어필해주세요.</label>
                            <br>
                            <textarea class="form-control" type="content" row="10" id="introduce" name="introduce"
                            placeholder="자신의 매력을 마음 것 적어주세요. :)"></textarea>
                            <div id=text_cnt>(0/500)</div>
                        </div>

                        <div class="form-group has-feedback">
                            <button class="btn btn-success" type="submit" id="submit">프로필 완성</button>
                        </div>
                    </form>
                </section>
                
            </body>
            
            </html>