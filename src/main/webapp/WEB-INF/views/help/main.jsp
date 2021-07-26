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
  <c:if >
  <a class="nav-link" href="${appRoot}/help/list">1:1 문의하기</a>
  
  </c:if>
  
  <a class="nav-link" href="#">Link</a>
  <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
</nav>
</div>
<pj:footer/>
</body>
</html>