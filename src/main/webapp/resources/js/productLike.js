// get.jsp 좋아요 기능(전부 로딩 되었을 때 실행)
window.onload = function() {
	// 해당 상품에 좋아요를 누른 적 있는지 체크
	var likeCheck = $('#like-check-like').val();
	
	// 좋아요 개수
	var likeCnt = parseInt($('#like-cnt').text());
	
	// 'data'로 넘길 값들
	var pid = $('#like-product-id').val();
	var uid = $('#like-user-id').val();
	var data = {
		product_id: pid,
		user_id: uid
	};
	
	// 상품이 보여질 때(get) 해당 상품에 좋아요를 누른 적 있으면 꽉찬 하트로 표시 해주기
	if (likeCheck == '1') {
		$('#like-i').removeClass('far fa-heart').addClass('fas fa-heart');
	}
		
	// 좋아요 버튼 눌렀을 때
	$('#like-icon').click(function() {
	
		// 해당 상품에 좋아요를 누른적이 없으면 좋아요 실행
		if (likeCheck != '1') {
		
			$.ajax({
				type: 'post',
				url: appRoot + '/product/likes/like',
				data: JSON.stringify(data),
				contentType: 'application/json',
				success: function() {
					console.log("좋아요 성공");
					
					// 좋아요를 누르면 꽉찬 하트로 표시 해주기
					$('#like-i').removeClass('far fa-heart').addClass('fas fa-heart');
					
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
		
		// 해당 상품에 좋아요를 누른적이 있으면 좋아요 취소
		} else {
	
			$.ajax({
				type: 'post',
				url: appRoot + '/product/likes/dislike',
				data: JSON.stringify(data),
				contentType: 'application/json',
				success: function() {
					console.log('좋아요 취소 성공');
					
					// 좋아요를 취소하면 빈 하트로 표시 해주기
					$('#like-i').removeClass('fas fa-heart').addClass('far fa-heart');
					
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
	
};