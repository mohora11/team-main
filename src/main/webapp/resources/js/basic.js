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
				$('#nav-home').addClass('active');
			});
			break;
 		case 'team/product/webtoon/list':
 			$(function() {
				$('#nav-webtoon').addClass('active');
			});
			break;
 		case 'team/product/webnovel/list':
 			$(function() {
				$('#nav-webnovel').addClass('active');
			});
			break;
 		case 'team/product/book/list':
 			$(function() {
				$('#nav-book').addClass('active');
			});
			break;
 		case 'team/board/list':
 			$(function() {
				$('#nav-board').addClass('active');
			});
			break;
 		case 'team/qna/list':
 			$(function() {
				$('#nav-qna').addClass('active');
			});
			break;
 	}
 	
 });