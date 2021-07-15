<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="team-header" class="d-flex flex-column sticky-top pt-3 mb-3">
	<div id="team-header-above" class="mx-auto mb-2">
		<nav class="navbar navbar-light">
			<a class="navbar-brand" href="${appRoot}/main">Project 로고 위치</a>
			<ul class="nav justify-content-end">
				<li class="nav-item mr-3">
					<form class="form-inline">
						<input class="form-control mr-sm-2 justify-content-end" type="search" aria-label="Search">
						<span><i class="fas fa-search"></i></span>
					</form>
				</li>
				<li class="nav-item">
					<a href="${appRoot}/member/login" class="btn btn-primary">로그인</a>
				</li>
			</ul>
		</nav>
	</div>
	<div id="team-header-below" class="mx-auto mt-2">
		<ul class="nav nav-pills nav-fill">
			<li class="nav-item">
				<a class="nav-link text-dark" href="${appRoot}/main">홈</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-dark" href="${appRoot}/product/webtoon/list">웹툰</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-dark" href="${appRoot}/product/webnovel/list">웹소설</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-dark" href="${appRoot}/product/book/list">책</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-dark" href="#">게시판</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-dark" href="#">고객센터</a>
			</li>
		</ul>
	</div>
</div>