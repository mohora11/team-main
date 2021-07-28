<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>
<link href="<c:url value='/resources/css/basic.css'/>" rel="stylesheet" />

<title>Insert title here</title>
<script type="text/javascript">
var passwordfin = false;
$(function() {
	$("#signup").click(function() {
		
		var userid = $("#sang-userid").val();
		var idName = $("#sang-userName").val();	
		var idEmail = $("#sang-userEmail").val();
		var data = {userid : userid, userName : idName, userEmail : idEmail};
		
		$.ajax({
			type: "post",
			url: "${appRoot}/member/findpw",
			data : JSON.stringify(data),
			contentType : "application/json",
			success: function (data) {
				
				if (data == 'success') {
					
					$(".result").removeAttr("hidden");
					
				} else if (data == 'exist') {
					
					alert("일치하는 아이디, 이름과 Email이 없습니다.");
					
					$(".result").attr("hidden", "hidden");
				}
				
				
			},
			error: function() {
				alert("정확한 정보를 적어주세요.");
				$("#sang-userid").val("");
				$("#sang-userName").val("");
				$("#sang-userEmail").val("");
				$(".result").attr("hidden", "hidden");
			}
			
		});
		
	});
	
	$("#sang-pw-conform, #sang-pw").keyup(function() {
		var pw1 = $("#sang-pw").val();
		var pw2 = $("#sang-pw-conform").val();
		var submitBtn = $("#signup-btn1");
		passwordConfirm = false;
		
		if (pw1 != pw2) {
			passwordConfirm = false;
			$("#password-message").removeClass("text-success");
			$("#password-message").addClass("text-danger");
			$("#password-message").text("패스워드가 일치하지 않습니다.");	
		} else {
			
			if(pw1 == ""){
				passwordConfirm = false;
				$("#password-message").text("패스워드를 입력해 주세요.");
			}else{
				passwordConfirm = true;
				$("#password-message").removeClass("text-danger");
				$("#password-message").addClass("text-success");
				$("#password-message").text("패스워드가 일치합니다.");
				passwordfin = true;
			}
		}
	});
});
</script>
</head>
<body>
<pj:navbar />
<div class="container">
   <form action="">
   					<div>
   					<h5>
						ID
					</h5>
					<input type="text" id="sang-userid" name="userid" class="" title="userid" >
   					</div>
  					<br>
					<div>
  										<h5>
						이름
					</h5>
					<input type="text" id="sang-userName" name="userName" class="" title="userName" >
					</div>
					<br>
					<div>
										<h5>
						E-mail
					</h5>
					<input type="text" id="sang-userEmail" name="usermail" class="" title="userEmail" >
					</div>
  					<input class="button" type="button" id="signup" value="찾기">
  
  					<hr hidden class="result">
			
			<form action="">
				<div hidden style="margin: 0 auto;" class="col-5 result">
				<div style="text-align: left;">
					<h5>
						비밀번호
					</h5>
				</div>
				</div>
				<div hidden class="ps_box col-5 result">
					<input style="border:none; outline: none; width: 330px;" type="password" id="sang-pw" name="userpw" class="" title="PW" maxlength="30">
	            </div>
	            <div style="margin-top: 25px"></div>
				
				<div hidden style="margin: 0 auto;" class="col-5 result">
				<div style="text-align: left;">
					<h5>
						비밀번호 확인
					</h5>
				</div>
				</div>
				<div hidden class="ps_box col-5 result">
					<input style="border:none; outline: none; width: 330px;" type="password" id="sang-pw-conform" name="password" class="" title="PW" maxlength="30">
				</div>
				<small hidden style="white-space: pre-wrap;" id="password-message" class="form-text text-danger result"> </small>
				<div style="margin-top: 25px"></div>
				
				<input hidden class="button result" type="button" id="signupchange" value="바꾸기">			
			</form>
   </form>
</div>
<pj:footer />
</body>
</html>