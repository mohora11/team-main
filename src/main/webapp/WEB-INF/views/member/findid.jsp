<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp"%>

<title>아이디 찾기</title>
<script>
$(function() {
	$("#gogofindid").click(function() {
		
		var findname = $("#findid-username").val();	
		var findmail = $("#findmail-usermail").val();
		var data = {username : findname, usermail : findmail};
		
		$.ajax({
			type: "post",
			url: "${appRoot}/member/findid",
			data : JSON.stringify(data),
			contentType : "application/json",
			success: function (data) {
				console.log(data);
				if (data.length > 0) {
					
					$(".result").removeAttr("hidden");
					showList(data);
					
				} else {
					alert("일치하는 이름과 Email이 없습니다.");
					
					$(".result").attr("hidden", "hidden");
				}
				
			},
			error: function() {
				alert("정확한 정보를 적어주세요.");
				$("#findid-username").val("");
				$("#findmail-usermail").val("");
				$(".result").attr("hidden", "hidden");
			}
			
		});
		
	});
	
	function showList(list) {
		var container = $("#resultid").empty();
		
		for (var userid of list) {
			var useridHTML = `
				<li class="media" id="userid\${userid}" data-rno="\${userid}">
					<div class="media-body">
						<p style="margin: 8px 0px; font-family: GongGothicMedium;">\${userid}</p>
					</div>
				</li>`;
			
			container.append(useridHTML);
		}
	}
	
});
	

</script>

</head>
<body>
	<pj:navbar></pj:navbar>
	<div class="container">

		<h1>아이디 찾기</h1>

		<form action="">
			<h5>이름</h5>
			<div>
				<input type="text" id="findid-username" name="userName" class=""
					title="username" autofocus="autofocus">
			</div>

			<h5>email</h5>

			<div>
				<input type="text" id="findid-usermail" name="usermail" class=""
					title="usermail" autofocus="autofocus">
			</div>

			<input class="button" type="button" id="gogofindid" value="찾기">
		</form>

		<hr hidden class="result">
		<h5>고객님의 정보와 일치하는 아이디 입니다.</h5>
		
		<div id="resultid" hidden>
			
		</div>
	</div>
</body>
</html>