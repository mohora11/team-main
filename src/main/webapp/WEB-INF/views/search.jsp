<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>search</title>
</head>
<body>
<pj:navbar />
<div class="container">
	<div id="div-white" class="container">
	<ul class="list-group list-group-horizontal">
		<li class="list-group-item">${cri.keyword}(으)로 검색한 결과입니다.</li>
	</ul>
	<form class="form-inline">
		<c:forEach items="${list}" var="main">
			<c:choose>
				<c:when test="${main.product_category eq '1'}">
					<c:url value="/product/webtoon/get" var="getUrl">
						<c:param name="id">${main.id}</c:param>
					</c:url>
					<a href="${getUrl}">
						<div id="product-list-div" class="card mx-2 my-2">
							<img src="${imgRoot}webtoon/${main.id}/cover/${main.file_name}" class="card-img-top">
							<div class="card-body">
								<p class="card-text text-dark">${main.product_name}</p>
							</div>
						</div>
					</a>
				</c:when>
				<c:when test="${main.product_category eq '2'}">
					<c:url value="/product/webnovel/get" var="getUrl">
						<c:param name="id">${main.id}</c:param>
					</c:url>
					<a href="${getUrl}">
						<div id="product-list-div" class="card mx-2 my-2">
							<img src="${imgRoot}webnovel/${main.id}/cover/${main.file_name}" class="card-img-top">
							<div class="card-body">
								<p class="card-text text-dark">${main.product_name}</p>
							</div>
						</div>
					</a>
				</c:when>
				<c:when test="${main.product_category eq '3'}">
					<c:url value="/product/book/get" var="getUrl">
						<c:param name="id">${main.id}</c:param>
					</c:url>
					<a href="${getUrl}">
						<div id="product-list-div" class="card mx-2 my-2">
							<img src="${imgRoot}book/${main.id}/cover/${main.file_name}" class="card-img-top">
							<div class="card-body">
								<p class="card-text text-dark">${main.product_name}</p>
							</div>
						</div>
					</a>
				</c:when>
			</c:choose>
		</c:forEach>
	</form>
</div>
</div>
<pj:footer />
</body>
</html>