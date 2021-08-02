// 게시글 좋아요 기능(전부 로딩 되었을 때 실행)
window.onload = function() {
	// 해당 게시글에 좋아요를 누른 적 있는지 체크
	var likeCheck = $('#like-check-like').val();
	// 해당 게시글에 싫어요를 누른 적 있는지 체크
	var dislikeCheck = $('#like-check-dislike').val();
	
	// 좋아요 개수
	var likeCnt = parseInt($('#like-cnt').text());
	// 싫어요 개수
	var dislikeCnt = parseInt($('#dislike-cnt').text());
	
	// 'data'로 넘길 값들
	var bno = $('#like-bno').val();
	var uid = $('#like-user-id').val();
	var data = {
		bno: bno,
		writer: uid
	};
	
	// 게시글이 보여질 때(get) 해당 게시글에 좋아요를 누른 적 있으면 버튼 변경
	if (likeCheck == '1') {
		$('#like-btn').removeClass('btn-primary').addClass('btn-secondary');
	}
	// 게시글이 보여질 때(get) 해당 게시글에 싫어요를 누른 적 있으면 버튼 변경
	if (dislikeCheck == '1') {
		$('#dislike-btn').removeClass('btn-danger').addClass('btn-secondary');
	}
		
	// 좋아요 버튼 눌렀을 때
	$('#like-btn').click(function() {
	
		// 해당 게시글에 좋아요를 누른적이 없으면 좋아요 실행
		if (likeCheck != '1') {
		
			$.ajax({
				type: 'post',
				url: appRoot + '/board/likes/like',
				data: JSON.stringify(data),
				contentType: 'application/json',
				success: function() {
					console.log("좋아요 성공");
					
					// 좋아요를 누르면 버튼 변경
					$('#like-btn').removeClass('btn-primary').addClass('btn-secondary');
					
					// 현재 보여지는 좋아요 개수에서 +1
					$('#like-cnt').text(likeCnt + 1);
					likeCnt = likeCnt + 1;
					
					// 좋아요 눌렀다는 기록 표시
					likeCheck = '1';
				},
				error: function() {
					console.log("좋아요 실패");
				}
			});
		
		// 해당 게시글에 좋아요를 누른적이 있으면 좋아요 취소
		} else {
	
			$.ajax({
				type: 'post',
				url: appRoot + '/board/likes/cancelLike',
				data: JSON.stringify(data),
				contentType: 'application/json',
				success: function() {
					console.log('좋아요 취소 성공');
					
					// 좋아요를 누르면 버튼 변경
					$('#like-btn').removeClass('btn-secondary').addClass('btn-primary');
					
					// 현재 보여지는 좋아요 개수에서 -1
					$('#like-cnt').text(likeCnt - 1);
					likeCnt = likeCnt - 1;
					
					// 좋아요 취소했다는 기록 표시
					likeCheck = '0';
				},
				error: function() {
					console.log("좋아요 취소 실패");
				}
			});
		}
	});
	// 싫어요 버튼 눌렀을 때
	$('#dislike-btn').click(function() {
	
		// 해당 게시글에 싫어요를 누른적이 없으면 싫어요 실행
		if (dislikeCheck != '1') {
		
			$.ajax({
				type: 'post',
				url: appRoot + '/board/likes/dislike',
				data: JSON.stringify(data),
				contentType: 'application/json',
				success: function() {
					console.log("싫어요 성공");
					
					// 싫어요를 누르면 버튼 변경
					$('#dislike-btn').removeClass('btn-danger').addClass('btn-secondary');
					
					// 현재 보여지는 싫어요 개수에서 +1
					$('#dislike-cnt').text(dislikeCnt + 1);
					dislikeCnt = dislikeCnt + 1;
					
					// 싫어요 눌렀다는 기록 표시
					dislikeCheck = '1';
				},
				error: function() {
					console.log("싫어요 실패");
				}
			});
		
		// 해당 게시글에 싫어요를 누른적이 있으면 싫어요 취소
		} else {
	
			$.ajax({
				type: 'post',
				url: appRoot + '/board/likes/cancelDislike',
				data: JSON.stringify(data),
				contentType: 'application/json',
				success: function() {
					console.log('싫어요 취소 성공');
					
					// 싫어요를 누르면 버튼 변경
					$('#dislike-btn').removeClass('btn-secondary').addClass('btn-danger');
					
					// 현재 보여지는 싫어요 개수에서 -1
					$('#dislike-cnt').text(dislikeCnt - 1);
					dislikeCnt = dislikeCnt - 1;
					
					// 싫어요 취소했다는 기록 표시
					dislikeCheck = '0';
				},
				error: function() {
					console.log("싫어요 취소 실패");
				}
			});
		}
	});
	
};