<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="team-header" class="d-flex flex-column sticky-top pt-3 mb-3">
	<div id="team-header-above" class="mx-auto mb-2">
		<nav class="navbar navbar-light">
			<a class="navbar-brand" href="${appRoot}/main">Project 로고 위치</a>
			<ul class="nav justify-content-end">
				<li class="nav-item mr-3">
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
					<li class="nav-item">
						<a href="${appRoot}/member/login" class="btn btn-primary">로그인</a>
					</li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item">
						<div class="dropdown">
							<span id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i id="dropdownMenuIcon" class="far fa-user"></i></span>
							
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
								<a class="dropdown-item" href="${appRoot}/member/modify">내 정보</a>
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
			<li class="nav-item">
				<a id="nav-home" class="nav-link text-dark" href="${appRoot}/main">홈</a>
			</li>
			<li class="nav-item">
				<a id="nav-webtoon" class="nav-link text-dark" href="${appRoot}/product/webtoon/list">웹툰</a>
			</li>
			<li class="nav-item">
				<a id="nav-webnovel" class="nav-link text-dark" href="${appRoot}/product/webnovel/list">웹소설</a>
			</li>
			<li class="nav-item">
				<a id="nav-book" class="nav-link text-dark" href="${appRoot}/product/book/list">책</a>
			</li>
			<li class="nav-item">
				<a id="nav-board" class="nav-link text-dark" href="${appRoot}/board/list">게시판</a>
			</li>
			<li class="nav-item">
				<a id="nav-qna" class="nav-link text-dark" href="${appRoot}/qna/list">고객센터</a>
			</li>
		</ul>
	</div>
</div>