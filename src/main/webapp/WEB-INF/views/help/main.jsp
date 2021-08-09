<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp"%>


<title>고객센터</title>
</head>
<body>
	<pj:navbar />
	<div class="container">
		<h3>자주 묻는 질문</h3>
		<div class="accordion" id="accordionExample">
			<div class="card">
				<div class="card-header" id="headingOne">
					<h2 class="mb-0">
						<button class="btn btn-link btn-block text-left collapsed"
							type="button" data-toggle="collapse" data-target="#collapseOne"
							aria-expanded="false" aria-controls="collapseOne">
							<b>캐시는 어떻게 충전하나요?</b>
						</button>
					</h2>
				</div>

				<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
					data-parent="#accordionExample">
					<div class="card-body">로그인 후 메인화면에서 우측상단의 사람모양을 클릭하시고 캐시충전란을
						누르면 화면으로 이동합니다</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingTwo">
					<h2 class="mb-0">
						<button class="btn btn-link btn-block text-left collapsed"
							type="button" data-toggle="collapse" data-target="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo">
							<b>환불은 어떻게 하나요?</b>
						</button>
					</h2>
				</div>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionExample">
					<div class="card-body">
						<b>환불정책은 따로 없습니다.</b>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingThree">
					<h2 class="mb-0">
						<button class="btn btn-link btn-block text-left collapsed"
							type="button" data-toggle="collapse" data-target="#collapseThree"
							aria-expanded="false" aria-controls="collapseThree">
							<b>웹툰의 업데이트 시간은 언제인가요?</b>
						</button>
					</h2>
				</div>
				<div id="collapseThree" class="collapse"
					aria-labelledby="headingThree" data-parent="#accordionExample">
					<div class="card-body">연재되는 전날 오후 11시 기준으로 작가님이 올려주신 순서대로 업데이트 됩니다.</div>
				</div>
			</div>
		</div>


		</tr>

		<nav class="nav flex-column"></nav>
	</div>
	<pj:footer />
</body>
</html>