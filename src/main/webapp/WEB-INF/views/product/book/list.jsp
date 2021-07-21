<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>book list</title>
</head>
<body>
<pj:navbar />

<%-- carousel --%>
<div class="container mb-3">
<div id="carousel-product" class="carousel slide" data-ride="carousel">
	<div class="carousel-inner">
		<div id="carousel-item" class="carousel-item active" data-interval="3000">
			<a href="${appRoot}/product/book/get?id=">
				<img src="https://www.freemockupworld.com/wp-content/uploads/2019/12/Free-Book-Cover-Mockup-PSD.jpg">
			</a>
			<div class="carousel-caption d-none d-md-block">
				<h5>First slide label</h5>
				<p>Some representative placeholder content for the first slide.</p>
			</div>
		</div>
		<div id="carousel-item" class="carousel-item" data-interval="3000">
			<a href="">
				<img src="https://www.free-mockup.com/wp-content/uploads/edd/2020/10/Letter-Size-Cover-Branding-Book-Free-Mockup.jpg">
			</a>
			<div class="carousel-caption d-none d-md-block">
				<h5>Second slide label</h5>
				<p>Some representative placeholder content for the second slide.</p>
			</div>
		</div>
		<div id="carousel-item" class="carousel-item" data-interval="3000">
			<a href="">
				<img src="https://tacchi-canvas-prod.s3.amazonaws.com/uploads/work_image/data/1792/My_creation_by_Alvaro_Arregui__Entrepreneur_in_Tokyo.jpg">
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

<%-- book list --%>
<div id="div-white" class="container">
	<ul class="list-group list-group-horizontal">
		<li class="list-group-item">전체 책 목록</li>
	</ul>
	<form class="form-inline">
		<c:forEach items="${list}" var="book">
			<c:url value="/product/book/get" var="getUrl">
				<c:param name="id">${book.id}</c:param>
			</c:url>
			<a href="${getUrl}">
				<div id="product-list-div" class="card mx-2 my-2">
					<img src="${imgRoot}book/${book.id}/cover/${book.file_name}" class="card-img-top">
					<div class="card-body">
						<p class="card-text text-dark">${book.product_name}</p>
					</div>
				</div>
			</a>
		</c:forEach>
	</form>
</div>

<!-- Modal -->
<%@ include file="/WEB-INF/subModules/bookModal.jsp" %>

<pj:footer />
</body>
</html>