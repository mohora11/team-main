/**
 * 
 */
 
 $(function() {
 
 	// navbar에서 선택한 category를 active 상태로 변경하여 navbar에 현재 category 표시
 	var currentUrl = document.location.href.split('http://localhost:8080/');
 	var splitUrl = currentUrl[1];
 	
 	switch (splitUrl) {
 		case 'team/main':
 			$(function() {
				$('#nav-home-underline').addClass('active').animate({width: '100%'}, 600);
			});
			break;
 		case 'team/product/webtoon/list':
 			$(function() {
				$('#nav-webtoon-underline').addClass('active').animate({width: '100%'}, 600);
			});
			break;
 		case 'team/product/webnovel/list':
 			$(function() {
				$('#nav-webnovel-underline').addClass('active').animate({width: '100%'}, 600);
			});
			break;
 		case 'team/product/book/list':
 			$(function() {
				$('#nav-book-underline').addClass('active').animate({width: '100%'}, 600);
			});
			break;
 		case 'team/board/list':
 			$(function() {
				$('#nav-board-underline').addClass('active').animate({width: '100%'}, 600);
			});
			break;
 		case 'team/qna/list':
 			$(function() {
				$('#nav-qna-underline').addClass('active').animate({width: '100%'}, 600);
			});
			break;
 	}
 	
 	// contextPath 구하기
 	function getContextPath(){
	    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	    var contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
	    return contextPath;
	}
	
	// 상태 modal
	if (history.state == null) {
		$('#stateModal').modal('show');
		history.replaceState({}, null);
	}
	
	// 뒤로가기 버튼
	$('#back-btn').click(function() {
		history.back();
	});
 	
 	// ADMIN 작품 등록
 	$('#product-register-btn').click(function(e) {
 		var category = $('#product-register-input1').val();
 		e.preventDefault();
 		
 		if (category == '1') {
			$("#product-register-form")
			.attr("action", getContextPath() + "/product/webtoon/register")
			.submit();
		} else if (category == '2') {
			$("#product-register-form")
			.attr("action", getContextPath() + "/product/webnovel/register")
			.submit();
		} else if (category == '3') {
			$("#product-register-form")
			.attr("action", getContextPath() + "/product/book/register")
			.submit();
		} else {
			alert('카테고리를 선택해주세요!');
		}
 	});
 	
 	// ADMIN 책 삭제
 	$('#book-remove-btn').click(function(){
		if (confirm("삭제 하시겠습니까?")) {
			$('#book-modify-form')
			.attr('action', getContextPath() + "/product/book/remove")
			.submit();
		}
	});
 	
 	// 책 보기
 	$('#book-detail-btn').click(function(e) {
 		e.preventDefault;
 		
 		$("#book-get-form")
		.attr("action", getContextPath() + "/product/book/detail")
		.submit();
 	});
 	
 });