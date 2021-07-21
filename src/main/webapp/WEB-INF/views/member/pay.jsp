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
<script src="${appRoot }/resources/js/jq.js"></script>

</head>
<body>
<pj:navbar />
<div class="container">

   <h1>충전페이지</h1>
	
	<div>
	<button id="apibtn">카카오 페이 충전하기 5000원</button>
	</div>

</div>
<pj:footer />
</body>
</html>