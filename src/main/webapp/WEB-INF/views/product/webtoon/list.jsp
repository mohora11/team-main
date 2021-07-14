<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>
<link href="<c:url value='/resources/css/basic.css'/>" rel="stylesheet" />

<title>webtoon list</title>
</head>
<body>
<pj:navbar />

<%-- carousel --%>
<div class="container mb-3">
<div id="carousel-product" class="carousel slide" data-ride="carousel">
	<div class="carousel-inner">
		<div id="carousel-item" class="carousel-item active" data-interval="3000">
			<a href="${appRoot}/product/webtoon/get?id=">
				<img src="https://images.squarespace-cdn.com/content/v1/56453b08e4b0a48587b1d60e/1513115813558-PO6GGTW3GVX29R269Y1E/Mooncakes+Cover-1.jpg?format=500w">
			</a>
			<div class="carousel-caption d-none d-md-block">
				<h5>First slide label</h5>
				<p>Some representative placeholder content for the first slide.</p>
			</div>
		</div>
		<div id="carousel-item" class="carousel-item" data-interval="3000">
			<a href="">
				<img src="https://www.namesakecomic.com/comics/storybegins.jpg">
			</a>
			<div class="carousel-caption d-none d-md-block">
				<h5>Second slide label</h5>
				<p>Some representative placeholder content for the second slide.</p>
			</div>
		</div>
		<div id="carousel-item" class="carousel-item" data-interval="3000">
			<a href="">
				<img src="https://payload.cargocollective.com/1/14/467040/9121427/traveloguemini_web_670.png">
			</a>
			<div class="carousel-caption d-none d-md-block">
				<h5>Third slide label</h5>
				<p>Some representative placeholder content for the third slide.</p>
			</div>
		</div>
	</div>
	<a class="carousel-control-prev" href="#carousel-product" role="button" data-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="carousel-control-next" href="#carousel-product" role="button" data-slide="next">
		<span class="carousel-control-next-icon" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div>
</div>

<%-- webtoon list --%>
<div id="div-white" class="container">
	<ul class="list-group list-group-horizontal">
		<li class="list-group-item">전체 웹툰 목록</li>
	</ul>
	<form class="form-inline">
		<c:forEach items="${list}" var="webtoon">
			<c:url value="/product/webtoon/get" var="getUrl">
				<c:param name="id">${webtoon.id}</c:param>
			</c:url>
			<a href="${getUrl}">
				<div id="product-list-div" class="card mx-2 my-2">
					<img src="https://images.squarespace-cdn.com/content/v1/56453b08e4b0a48587b1d60e/1513115813558-PO6GGTW3GVX29R269Y1E/Mooncakes+Cover-1.jpg?format=500w" class="card-img-top">
					<div class="card-body">
						<p class="card-text text-dark">${webtoon.product_name}</p>
					</div>
				</div>
			</a>
		</c:forEach>
	</form>
</div>

<pj:footer />
</body>
</html>