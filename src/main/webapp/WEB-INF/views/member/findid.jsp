<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp"%>
<link href="<c:url value='/resources/css/basic.css'/>" rel="stylesheet" />

<title>Insert title here</title>


  <script language="javascript">
  function showPopup() { window.open("popup1", "a", "width=400, height=300, left=100, top=50"); }
  
  
  
  </script>

<title>아이디 찾기</title>


</head>
<body>
	<pj:navbar />
	<div class="container">
		<h1>아이디 찾기</h1>

		<form action="${appRoot}/member/findid" method="post">
			<h5>이름</h5>
			<div>
				<input type="text" id="findid-username" name="username" />
			</div>

			<h5>email</h5>

			<div>
				<input type="text" id="findid-usermail" name="usermail" />
			</div>
		<br>
			<input class="button" type="submit" id="gogofindid" value="찾기">
		</form>
		
		<hr>

		<div id="resultid" >
			<h3>${userid}</h3>
			<input type="button" value="팝업창" onclick="showPopup();" />
		</div>
	</div>
	<pj:footer />
</body>
</html>