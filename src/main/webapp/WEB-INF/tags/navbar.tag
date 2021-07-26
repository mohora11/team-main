<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url value="/member/info" var="memberInfoUrl">
	<c:if test="${not empty cri.pageNum }">
		<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	</c:if>
	<c:if test="${not empty cri.amount }">
		<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
		<c:param name="keyword" value="${cri.keyword }"></c:param>
		<c:param name="type" value="${cri.type }"></c:param>
</c:url>

<c:url value="/member/signup" var="signUpUrl">
	<c:if test="${not empty cri.pageNum }">
		<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	</c:if>
	<c:if test="${not empty cri.amount }">
		<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
		<c:param name="keyword" value="${cri.keyword }"></c:param>
		<c:param name="type" value="${cri.type }"></c:param>
</c:url>

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
					<li id="login-btn" class="nav-item">
						<a href="${appRoot}/member/login" id="login-btn-link">로그인</a>
					</li>
				</sec:authorize>
			
	  <sec:authorize access="isAuthenticated()">
	  <form action="${appRoot }/logout" method="post">
	  	<input type="submit" class="btn btn-outline-secondary" value="로그아웃">
	  </form>
  </sec:authorize>		
			
	  <sec:authorize access="!isAuthenticated()">
	  	<li class="nav-item">
	  		<a class="nav-link" href="${signUpUrl }">회원가입</a>
	  	</li>
	  </sec:authorize>
					  <sec:authorize access="isAuthenticated()"> 
	  	<li>
	  		<a class="nav-link" href="${memberInfoUrl }">회원정보 </a>
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
								<a class="dropdown-item" href="${appRoot}/member/pay">캐시 충전</a>
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
			<li class="nav-item">
				<a id="nav-home" class="nav-link text-dark" href="${appRoot}/main">홈</a>
				<span id="nav-home-underline" class=""></span>
			</li>
			<li class="nav-item">
				<a id="nav-webtoon" class="nav-link text-dark" href="${appRoot}/product/webtoon/list">웹툰</a>
				<span id="nav-webtoon-underline" class=""></span>
			</li>
			<li class="nav-item">
				<a id="nav-webnovel" class="nav-link text-dark" href="${appRoot}/product/webnovel/list">웹소설</a>
				<span id="nav-webnovel-underline" class=""></span>
			</li>
			<li class="nav-item">
				<a id="nav-book" class="nav-link text-dark" href="${appRoot}/product/book/list">책</a>
				<span id="nav-book-underline" class=""></span>
			</li>
			<li class="nav-item">
				<a id="nav-board" class="nav-link text-dark" href="${appRoot}/board/list">게시판</a>
				<span id="nav-board-underline" class=""></span>
			</li>
			<li class="nav-item">
				<a id="nav-qna" class="nav-link text-dark" href="${appRoot}/help/list">고객센터</a>
				<span id="nav-qna-underline" class=""></span>
			</li>
		</ul>
	</div>
</div>