<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>
<link href="<c:url value='/resources/css/basic.css'/>" rel="stylesheet" />

<title>Insert title here</title>
<script src="${appRoot }/resources/js/jq.js"></script>


	
</head>
<body>
<pj:navbar />
<div class="container">


   <h1>충전페이지</h1>
	
	<div>
	<button id="apibtn">카카오 페이 충전하기 5000원</button>
	</div>

	<div>
	<a href="${appRoot}/member/PaymentWindow" id="login-btn-link">아임포트 충전 테스트 </a>
	</div>
	
		<div>
	<a href="${appRoot}/member/pay2" id="login-btn-link">아임포트 충전 테스트2222222222 </a>
	</div>
	
	
	
	
	<div class="card-body bg-white mt-0 shadow">
                <p style="font-weight: bold">카카오 페이 결제</p>
                <label ><input type="radio" name="money" value="5000"><span>5,000원</span></label>
                <label ><input type="radio" name="money" value="10000"><span>10,000원</span></label>
                <label ><input type="radio" name="money" value="15000"><span>15,000원</span></label>
                <label ><input type="radio" name="money" value="20000"><span>20,000원</span></label>
                <label ><input type="radio" name="money" value="25000"><span>25,000원</span></label>
                <label ><input type="radio" name="money" value="30000"><span>30,000원</span></label>
                <label ><input type="radio" name="money" value="35000"><span>35,000원</span></label>
                <label ><input type="radio" name="money" value="40000"><span>40,000원</span></label>
                <label ><input type="radio" name="money" value="50000"><span>50,000원</span></label>
                <!-- <p  style="color: #ac2925; margin-top: 30px">최소 충전금액은 5,000원이며 <br/>최대 충전금액은 50,000원 입니다.</p> -->
                <button type="button" class="btn btn-lg btn-block  btn-custom" id="apibtn">충 전 하 기</button>
                </div>

 </div>
<pj:footer />
</body>
</html>