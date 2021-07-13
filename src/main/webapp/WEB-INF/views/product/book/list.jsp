<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>
<link href="<c:url value='/resources/css/basic.css'/>" rel="stylesheet" />

<title>book list</title>
</head>
<body>
<pj:navbar />

<%-- list --%>
<div class="container">
<form class="form-inline">
	<c:forEach items="${list}" var="book">
		<div id="book-list-div" class="card mx-2 my-2">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<p class="card-text">${book.product_name}</p>
			</div>
		</div>
	</c:forEach>
</form>
</div>

<pj:footer />
</body>
</html>