<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>

	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>동아줄 : 회원가입</title>

	<link rel="stylesheet" href="/resources/css/signUp.css">
</head>


<script type="text/javascript">
	$(document).ready(function () {
		var msg = '${msg}';
        if (msg.length > 0) {
            alert(msg);
        }
		$("#submit").on("click", function () {
			if ($("#email").val() == "") {
				alert("이메일을 입력해주세요.");
				$('#submit').attr('disabled', true)
				$("#email").focus();
				return false;
			} else {
				$('#submit').attr('disabled', false);
			}

			if ($("#passwd").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$('#submit').attr('disabled', true);
				$("#passwd").focus();
				return false;
			} else {
				$('#submit').attr('disabled', false);
			}

			if ($("#phonenumber").val() == "") {
				alert("휴대폰 번호를 입력해주세요.");
				$("#phonenumber").focus();
				return false;
			}

		});


		$('#passwd').keyup(function () {
			$('#chkNotice').html('');
		});

		$('#passwdCheck').keyup(function () {

			if ($('#passwd').val() != $('#passwdCheck').val()) {
				$('#chkNotice').html('비밀번호 일치하지 않음');
				$('#chkNotice').css('color', 'red');
				$('#submit').attr('disabled', true);
			} else {
				$('#chkNotice').html('비밀번호 일치함');
				$('#chkNotice').css('color', 'blue');
				$('#submit').attr('disabled', false);
			}

		});

		var emailChkVal = $("#emailCheck").val();
		console.log("******* emailChkVal: ", emailChkVal);

		if (emailChkVal != ' ' || emailChkVal != 'undefined') {
			$("#submit").attr("disabled", true);
				console.log('*****emailChkVal ', emailChkVal);

		if (emailChkVal == "N") {

			alert("중복확인 버튼을 눌러주세요.");
			$("#submit").attr("disabled", true);

		} else if (emailChkVal == "Y") {
			$("#regForm").submit();
		}

	}
	})

	function fn_emailCheck() {
		$.ajax({
			url: "/member/emailCheck",
			type: "post",
			dataType: "json",
			data: {
				"email": $("#email").val()
			},
			success: function (data) {
				if ($("#email").val() == '' || $("#email").val() == 'undefined') return;
				if (data == 1) {
					$("#emailCheck").attr("VALUE", "N");
					$("#submit").attr("disabled", true);
					alert("중복된 이메일입니다.");

				} else if (data == 0) {
					alert("사용가능한 이메일입니다.");
					$("#emailCheck").attr("VALUE", "Y");
					$("#submit").attr("disabled", false);
				}
			}
		}); // ajex

	}
</script>

<body>

	<section class="wrap">
	 <div class="login">
            <h2>Sign-Up</h2>
        <div id="wrap_child">    
		<form action="/member/signUp" method="POST" id="regForm">
			<div class="login_id">
				<label class="control-label" for="email">E-mail</label>
				<input class="form-control" type="email" id="email" name="email" />
				<button class="emailCheck" type="button" id="emailCheck" onclick="fn_emailCheck();"
					><strong>중복확인</strong></button>
			</div>
			<div class="login_pw">
				<label class="control-label" for="passwd">Password</label>
				<input class="form-control" type="password" id="passwd" name="passwd" />
			</div>
			<div class="login_pw">
				<label class="control-label" for="passwdCheck">Password Check</label>
				<input class="form-control" type="password" id="passwdCheck" name="passwdCheck" />
				<span id="chkNotice"></span>
			</div>

			<div class="login_id">
				<label class="control-label" for="phonenumber">Phone-number</label>
				<input class="form-control" type="text" id="phonenumber" name="phonenumber" />
			</div>
			<div class="submit">
				<button class="submit" type="submit" id="submit">Sign-Up</button>
			</div>
		</form>
		</div>
		</div>
	</section>

</body>

</html>