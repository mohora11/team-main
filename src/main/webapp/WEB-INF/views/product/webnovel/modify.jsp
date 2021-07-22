<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>modify</title>
</head>
<body>
<pj:navbar />
<div class="container">
	<h1>웹소설 수정/삭제</h1>
	<hr>
	<div class="row">
		<div class="col-12">
			<form action="${appRoot}/product/webnovel/modify" id="webnovel-modify-form" method="post" enctype="multipart/form-data">
				<input name="id" value="${webnovel.id}" hidden />
				<div class="form-group">
					<label for="webnovel-modify-input1">카테고리</label>
					<select id="webnovel-modify-input1" name="product_category" class="custom-select">
						<option value="3" selected>책</option>
					</select>
				</div>
				<div class="form-group">
					<label for="webnovel-modify-input2">장르</label>
					<input id="webnovel-modify-input2" name="product_genre" class="form-control" value="${webnovel.product_genre}" required />
				</div>
				<div class="form-group">
					<label for="webnovel-modify-input3">제목</label>
					<input id="webnovel-modify-input3" name="product_name" class="form-control" value="${webnovel.product_name}" required />
				</div>
				<div class="form-group">
					<label for="webnovel-modify-input4">작가</label>
					<input id="webnovel-modify-input4" name="writer_name" class="form-control" value="${webnovel.writer_name}" required />
				</div>
 				<div class="form-group">
					<label for="webnovel-modify-input5">작품 커버</label>
					<input type="file" id="webnovel-modify-input5" name="file1" class="form-control" accept="image/*" required />
				</div>
				<div class="form-group">
					<label for="webnovel-modify-input6">작품 파일</label>
					<input type="file" id="webnovel-modify-input6" name="file2" class="form-control" accept="image/*" required />
				</div>
				<button type="submit" id="webnovel-modify-btn" class="btn btn-secondary">수정</button>
				<button type="button" id="webnovel-remove-btn" class="btn btn-danger">삭제</button>
				<button type="button" id="back-btn" class="btn btn-light">취소</button>
			</form>
		</div>
	</div>
</div>
<pj:footer />
</body>
</html>