<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${not empty bookRegister}">
		<div class="modal fade" id="stateModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="stateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="stateModalLabel">알림</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">"${bookRegister}" 책이 등록되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:when>
	<c:when test="${not empty bookBeforeModify}">
		<div class="modal fade" id="stateModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="stateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="stateModalLabel">알림</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">"${bookBeforeModify.product_name}" 책이 수정되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
		</c:when>
	<c:when test="${not empty bookRemove}">
		<div class="modal fade" id="stateModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="stateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="stateModalLabel">알림</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">"${bookRemove}" 책이 삭제되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:when>
</c:choose>