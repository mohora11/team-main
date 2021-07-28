<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>


<title>고객센터</title>
</head>
<body>
<pj:navbar />
<div class="container">
	<nav class="nav flex-column">
  <a class="nav-link active" href="${appRoot }/help/main">찾아오시는 길</a>
  <%-- <c:if test="${pinfo.member}"> --%>
  <a class="nav-link" href="${appRoot}/help/list">1:1 문의하기</a>
  <%-- </c:if> --%>	
  <c:if test="${pinfo.member.userName eq 'admin'}">
  <a class="nav-link" href="${appRoot}/help/admin" >1:1 문의 관리</a>
  <a class="nav-link"  href="${appRoot}/board/report">신고함</a>
  </c:if>
</nav>
</div>
<pj:footer/>
</body>
</html>