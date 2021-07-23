<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pj" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>1:1 문의하기</title>
</head>
<body>
<pj:navbar />
<div class="container">
	<h4>1:1 문의하기</h4>
	
	<div class="row">
		<div class="col-12">
			<form action="${appRoot }/help/register" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="input1">제목</label>
					<input id="input1" class="form-control" name="htitle">
				</div>
				<div class="form-group">
					<label for="input3">파일</label>
					<input id="input3" class="form-control" type="file" name="file" accept="image/*">
				</div>
				<div class="form-group">
					<label for="textarea1">내용</label>
					<textarea id="textarea1" class="form-control" name="hcontent"></textarea>
				</div>
				<div class="form-group">
					<label for="input2">작성자</label>
					<input id="input2" type="hidden" value="${pinfo.member.userid }" readonly class="form-control" name="hwriter">
					<input value="${pinfo.member.userName }" readonly class="form-control">
				</div>
				<input class="btn btn-primary" type="submit" value="작성" />
			</form>
		</div>
	</div>
</div>
</body>
</html>