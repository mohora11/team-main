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
		<div id="resultid" >
			<h3>${userid}</h3>
		</div>
<pj:footer />
</body>
</html>