<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp"%>
<link href="<c:url value='/resources/css/basic.css'/>" rel="stylesheet" />

<title>아이디 찾기ㅣLeeBook</title>

</head>
<body>
	<pj:navbar />
	<div id="div-findid" class="container mt-5">
		<h2>아이디 찾기</h2>
		
		<br>

		<form action="${appRoot}/member/findid" method="post">
			<div class="form-group">
				<label for="findid-username">이름</label>
				<div class="input-group">
					<input type="text" id="findid-username" class="form-control" name="username" />
				</div>
			</div>
			<div class="form-group">	
				<label for="findid-usermail">이메일</label>
				<div class="input-group">
					<input type="text" id="findid-usermail" class="form-control" name="usermail" />
				</div>
			</div>
			<input class="btn btn-primary" type="submit" id="gogofindid" value="찾기">
		</form>
		
		<hr>

		<div id="resultid">
			<h3>${userid}</h3>
		</div>
	</div>
	<pj:footer />
</body>
</html>