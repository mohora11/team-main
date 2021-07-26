<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>likes</title>
</head>
<body>
<pj:navbar />
<div class="container">

	<c:url value="/member/likes" var="likesUrl">
		<c:param name="userid" value="${pinfo.member.userid}" />
	</c:url>
	<c:url value="/member/likesWebtoon" var="likesWebtoonUrl">
		<c:param name="userid" value="${pinfo.member.userid}" />
	</c:url>
	<c:url value="/member/likesWebnovel" var="likesWebnovelUrl">
		<c:param name="userid" value="${pinfo.member.userid}" />
	</c:url>
	<c:url value="/member/likesBook" var="likesBookUrl">
		<c:param name="userid" value="${pinfo.member.userid}" />
	</c:url>

	<%-- 찜 list --%>
	<div id="div-white" class="container">
		<ul class="list-group list-group-horizontal sel">
			<li class="list-group-item col-7">찜 목록</li>
			<ul class="list-group list-group-horizontal">
				<li class="list-group-item sel"><a href="${likesUrl}"><button type="button" class="btn btn-primary">전체</button></a></li>
				<li class="list-group-item sel"><a href="${likesWebtoonUrl}"><button type="button" class="btn btn-light">웹툰</button></a></li>
				<li class="list-group-item sel"><a href="${likesWebnovelUrl}"><button type="button" class="btn btn-light">웹소설</button></a></li>
				<li class="list-group-item sel"><a href="${likesBookUrl}"><button type="button" class="btn btn-light">  책</button></a></li>
			</ul>
		</ul>
		<form class="form-inline">
			<c:forEach items="${list}" var="list">
				<c:if test="${list.product_category eq '1'}">
					<c:url value="/product/webtoon/get" var="getUrl">
						<c:param name="id">${list.id}</c:param>
					</c:url>
					<a href="${getUrl}">
						<div id="product-list-div" class="card mx-2 my-2">
							<img src="${imgRoot}webtoon/${list.id}/cover/${list.file_name}" class="card-img-top">
							<div class="card-body">
								<p class="card-text text-dark">${list.product_name}</p>
							</div>
						</div>
					</a>
				</c:if>
				<c:if test="${list.product_category eq '2'}">
					<c:url value="/product/webnovel/get" var="getUrl">
						<c:param name="id">${list.id}</c:param>
					</c:url>
					<a href="${getUrl}">
						<div id="product-list-div" class="card mx-2 my-2">
							<img src="${imgRoot}webnovel/${list.id}/cover/${list.file_name}" class="card-img-top">
							<div class="card-body">
								<p class="card-text text-dark">${list.product_name}</p>
							</div>
						</div>
					</a>
				</c:if>
				<c:if test="${list.product_category eq '3'}">
					<c:url value="/product/book/get" var="getUrl">
						<c:param name="id">${list.id}</c:param>
					</c:url>
					<a href="${getUrl}">
						<div id="product-list-div" class="card mx-2 my-2">
							<img src="${imgRoot}book/${list.id}/cover/${list.file_name}" class="card-img-top">
							<div class="card-body">
								<p class="card-text text-dark">${list.product_name}</p>
							</div>
						</div>
					</a>
				</c:if>
			</c:forEach>
			<c:if test="${empty list}">
				<div class="container">
					<ul class="list-group">
						<li class="list-group-item"><h5>찜 목록이 비어있습니다.</h5></li>
					</ul>
				</div>
			</c:if>
		</form>
	</div>
</div>
<pj:footer />
</body>
</html>