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


</head>
<body>
<pj:navbar />
<div class="container">
   		<h1>비밀번호 찾기</h1>

		<form action="${appRoot}/member/findpw" method="post">
			
			<h5>아이디</h5>
			<div>
				<input type="text" id="findid-userid" name="userid" />
			</div>

			<h5>이름</h5>
			<div>
				<input type="text" id="findid-username" name="username" />
			</div>
			
			<h5>email</h5>
			<div>
				<input type="text" id="findid-usermail" name="usermail" />
			</div>
		<br>
			<input class="button" type="submit" id="gogofindid" value="찾기">
		</form>

		<hr>
		
		<div id="resultid">
			<h3>${userpw}</h3>
		</div>
	
</div>
<pj:footer />
</body>
</html>