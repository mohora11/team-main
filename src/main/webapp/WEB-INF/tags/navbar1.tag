<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url value="/member/likes" var="likesUrl">
	<c:param name="userid" value="${pinfo.member.userid}"></c:param>
</c:url>

<div id="team-header" class="d-flex flex-column sticky-top pt-3 mb-3">
	<div id="team-header-above" class="mx-auto mb-2">
		<nav class="navbar navbar-light">
			<a class="navbar-brand" href="${appRoot}/main">Project 로고 위치</a>
			<ul class="nav justify-content-end">
				<li id="navbar-search" class="nav-item mr-3">
					<form class="form-inline">
						<div class="input-group mr-sm-2">
							<input type="text" id="navbar-search-input" class="form-control">
						    <div class="input-group-prepend">
								<div id="navbar-search-icon" class="input-group-text"><span><i class="fas fa-search"></i></span></div>
						    </div>
					  	</div>
					</form>
				</li>
				<sec:authorize access="!isAuthenticated()">
					<li id="charge-btn" class="nav-item">
						<a href="${appRoot}/member/login" id="charge-btn-link">캐시충전</a>
					</li>
					<li id="login-btn" class="nav-item">
						<a href="${appRoot}/member/login" id="login-btn-link">로그인</a>
					</li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item">
						<div class="dropdown">
							<span id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i id="dropdownMenuIcon" class="far fa-user"></i></span>
							
							<div id="dropdown-menu" class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<a class="dropdown-item" href="${appRoot}/product/register">작품 등록</a>
									<div class="dropdown-divider"></div>
								</sec:authorize>
								<a class="dropdown-item"><small>내 캐시</small><br>x,xxx원</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="${appRoot}/member/info">회원 정보</a>
								<a class="dropdown-item" href="${likesUrl}">찜 목록</a>
								<a class="dropdown-item" href="${appRoot}/member/info">캐시 충전</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="${appRoot}/logout">로그아웃</a>
							</div>
						</div>
					</li>
				</sec:authorize>
			</ul>
		</nav>
	</div>
	<div id="team-header-below" class="mx-auto mt-2 pb-2">
		<ul class="nav nav-fill">
			<li id="navbar-btn" class="nav-item">
				<button type="button" id="back-btn" class="btn btn-light navbar-back-btn">뒤로가기</button>
			</li>
			<li id="navbar-product" class="nav-item" hidden>
				<div id="navbar-product-name">
					<c:choose>
						<c:when test="${not empty book.product_name}">
							${book.product_name}
						</c:when>
						<c:when test="${not empty webnovel.product_name}">
							${webnovel.product_name}
						</c:when>
						<c:when test="${not empty webtoon.product_name}">
							${webtoon.product_name}
						</c:when>
					</c:choose>
				</div>
			</li>
		</ul>
	</div>
</div>