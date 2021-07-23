/**
 * 
 */
$(function() {
	/* 댓글 목록 만들기 */
	function showReplyList(list) {
		var container = $("#reply-list-container").empty();
		
		for (var reply of list) {
			var replyHTML = `
				<li class="media" id="reply${reply.id}" data-id="${reply.id}">
					<div class="media-body">
						<div class="d-flex justify-content-between">
							<strong class="flex-grow-1 bd-highlight">${reply.replyer_name}</strong>
							<small class="bd-highlight text-muted">${new Date(reply.reply_date).toISOString().split("T")[0]}</small><br>
						</div>
						<small>${reply.reply}</small><hr>
					</div>
				</li>
			`;
			
			var replyComponent = $(replyHTML).click(function() {
				showModifyModal($(this).attr("data-id"));
			});
			
			container.append(replyComponent);
		}
	}
	
	/* 댓글 목록 가져오기 */
	function getReplyList() {
		$.ajax({
			type: "get",
			url: appRoot + "/product/replies/detail/pages/" + pid,
			success: function(list) {
				console.log(list);
				showReplyList(list);
			},
			error: function() {
				console.log("댓글 가져오는중 에러.");
			}
		});
	}
	
	/* 페이지 로딩 후 댓글 목록 가져오는 함수 실행 */
	getReplyList();
	
	/* 댓글 개수 */
	var replyCnt = parseInt($('#replyCnt').text());
	
	/* 댓글 입력 버튼 */
	$("#reply-insert-btn1").click(function() {
		var pid = $("#reply-pid-input1").val();
		var replyer = $("#reply-replyer-input1").val();
		var reply = $("#reply-reply-textarea1").val();
		
		var data = {
			product_id: pid,
			replyer: replyer,
			reply: reply
		};
		
		$.ajax({
			type: "post",
			url: appRoot + "/product/replies/detail/register",
			data: JSON.stringify(data),
			contentType: "application/json",
			success: function() {
				console.log("입력 성공");
				// 모달창 닫고
				$("#reply-insert-modal").modal("hide");
				// 댓글 리스트 가져오고
				getReplyList();
				// 현재 보여지는 댓글 개수 +1
				$('#replyCnt').text(replyCnt + 1);
				replyCnt = replyCnt + 1;
				// 안내 메세지 보여주기
				$("#reply-modal").modal("show");
				$("#reply-modal-body").text("새 댓글을 입력하였습니다.");
			},
			error: function() {
				console.log("입력 실패");
			}
		});
	});
	
	/* 댓글 클릭 시 modal 표시(수정/삭제) */
	function showModifyModal(id) {
		$.ajax({
			type: "get",
			url: appRoot + "/product/replies/detail/" + id,
			success: function(reply) {
				$("#reply-id-input2").val(reply.id);
				$("#reply-replyer-input2").val(reply.replyer);
				$("#reply-replyerName-input2").val(reply.replyer_name);
				$("#reply-reply-textarea2").text(reply.reply);
				
				// 댓글 작성자와 로그인 유저가 같지 않으면 수정/삭제 버튼 제거
				if (userid != reply.replyer) {
					$("#reply-modify-modal")
					  .find("#reply-modify-delete-btn-wrapper")
					  .hide();	
					
					$("#reply-reply-textarea2").attr("readonly", "readonly");
					
				} else {
					$("#reply-modify-modal")
					  .find("#reply-modify-delete-btn-wrapper")
					  .show();	
					
					$("#reply-reply-textarea2").removeAttr("readonly");
				}
				
				$("#reply-modify-modal").modal("show");
			},
			error: function() {
				console.log("댓글 가져오기 실패");
			}
		});
	}
	
	/* 댓글 수정 버튼 */
	$("#reply-modify-btn1").click(function() {
		var id = $("#reply-id-input2").val();
		var pid = $("#reply-pid-input2").val();
		var replyer = $("#reply-replyer-input2").val();
		var reply = $("#reply-reply-textarea2").val();
		
		var data = {
			id: id,
			product_id: pid,
			replyer: replyer,
			reply: reply
		};
		
		$.ajax({
			type: "put",
			url: appRoot + "/product/replies/detail/" + id,
			data: JSON.stringify(data),
			contentType: "application/json",
			success: function() {
				console.log("수정 성공");
				// 모달창 닫고
				$("#reply-modify-modal").modal("hide");
				// 댓글 리스트 가져오고
				getReplyList();
				// 안내 메세지 보여주기
				$("#reply-modal").modal("show");
				$("#reply-modal-body").text("댓글을 수정하였습니다.");
			},
			error: function() {
				console.log("수정 실패");
			}
		});
	});
	
	/* 댓글 삭제 버튼 */
	$("#reply-delete-btn1").click(function() {
		var check = confirm("삭제 하시겠습니까?");
		
		if (check) {
			var id = $("#reply-id-input2").val();
			var replyer = $("#reply-replyer-input2").val();
			
			var data = {
				id: id,
				replyer: replyer,
			};
			
			$.ajax({
				type: "delete",
				url: appRoot + "/product/replies/detail/" + id,
				data: JSON.stringify(data),
				contentType: "application/json",
				success: function() {
					console.log("삭제 성공");
					// 모달창 닫고
					$("#reply-modify-modal").modal("hide");
					// 댓글 리스트 가져오고
					getReplyList();
					// 현재 보여지는 댓글 개수 -1
					$('#replyCnt').text(replyCnt - 1);
					replyCnt = replyCnt - 1;
					// 안내 메세지 보여주기
					$("#reply-modal").modal("show");
					$("#reply-modal-body").text("댓글을 삭제하였습니다.");
				},
				error: function() {
					console.log("삭제 실패");
				}
			});
		}
	});
});