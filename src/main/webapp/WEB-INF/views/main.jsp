<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>main</title>
</head>
<body>
<pj:navbar />

<%-- all top 5 carousel --%>
<div class="container mb-3">
	<div id="carousel-product" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carousel-product" data-slide-to="0" class="active"></li>
			<li data-target="#carousel-product" data-slide-to="1"></li>
			<li data-target="#carousel-product" data-slide-to="2"></li>
			<li data-target="#carousel-product" data-slide-to="3"></li>
			<li data-target="#carousel-product" data-slide-to="4"></li>
		</ol>
		<div class="carousel-inner">
			<c:forEach items="${rank}" var="rank">
				<c:choose>
					<c:when test="${rank.product_category eq '1'}">
						<c:url value="/product/webtoon/get" var="getUrl">
							<c:param name="id">${rank.id}</c:param>
						</c:url>
						<div id="carousel-item" class="carousel-item" data-interval="3000">
							<a href="${getUrl}">
								<img src="${imgRoot}webtoon/${rank.id}/cover/${rank.file_name}">
							</a>
							<div class="carousel-caption d-none d-md-block">
								<h5>${rank.product_name}</h5>
								<p>${rank.writer_name}</p>
							</div>
						</div>
					</c:when>
					<c:when test="${rank.product_category eq '2'}">
						<c:url value="/product/webnovel/get" var="getUrl">
							<c:param name="id">${rank.id}</c:param>
						</c:url>
						<div id="carousel-item" class="carousel-item" data-interval="3000">
							<a href="${getUrl}">
								<img src="${imgRoot}webnovel/${rank.id}/cover/${rank.file_name}">
							</a>
							<div class="carousel-caption d-none d-md-block">
								<h5>${rank.product_name}</h5>
								<p>${rank.writer_name}</p>
							</div>
						</div>
					</c:when>
					<c:when test="${rank.product_category eq '3'}">
						<c:url value="/product/book/get" var="getUrl">
							<c:param name="id">${rank.id}</c:param>
						</c:url>
						<div id="carousel-item" class="carousel-item" data-interval="3000">
							<a href="${getUrl}">
								<img src="${imgRoot}book/${rank.id}/cover/${rank.file_name}">
							</a>
							<div class="carousel-caption d-none d-md-block">
								<h5>${rank.product_name}</h5>
								<p>${rank.writer_name}</p>
							</div>
						</div>
					</c:when>
				</c:choose>
			</c:forEach>
		</div>
		<a class="carousel-control-prev" href="#carousel-product" role="button" data-slide="prev">
			<i class="fas fa-angle-left"></i>
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#carousel-product" role="button" data-slide="next">
			<i class="fas fa-angle-right"></i>
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>

<%-- all list --%>
<div id="div-white" class="container">
	<ul class="list-group list-group-horizontal">
		<li class="list-group-item">전체 목록</li>
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

<pj:footer />
</body>
</html>