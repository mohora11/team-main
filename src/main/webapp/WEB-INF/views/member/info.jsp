<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<pj:navbar/>
	<h1>회원 정보</h1>
	<div class="row">
		<div class="col-12">
			<form id="member-info-form1" method="post" action="${appRoot }/member/modify">
				<div class="form-group">
					<label for="member-info-input1">아이디</label>
					<input readonly value="${member.userid }" type="text" class="form-control" id="member-info-input1" name="userid" >
				</div>
				<div class="form-group">
					<label for="member-info-input2">새 패스워드</label>
					
					<div class="input-group">
						<input type="password" class="form-control" id="member-info-input2" name="userpw">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary"
							        type="button"
							        id="toggle-password-btn">
							        
							        <i id="toggle-password-icon" class="far fa-eye"></i>
							        
							        </button> 
						</form>
						</div>
						</div>
						</div>

		
				



		</div>
	</div>
</body>
</html>

















