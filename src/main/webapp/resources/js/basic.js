$(function() {

	// navbar 검색창의 검색 아이콘 클릭해도 submit 시키기
	$('#search-icon').click(function() {
		$('#search-form').submit();
	});
	
	// navbar 검색창 focus in, out
	$('#navbar-search-input').on({
		focus: function() {
			$('#navbar-search-input').css('border-radius', '15px 0 0 0');
			$('#navbar-search-icon').css('border-radius', '0 15px 0 0');
			$('#search-rank').removeAttr('hidden');
		},
		blur: function() {
			$('#navbar-search-input').css('border-radius', '25px 0 0 25px');
			$('#navbar-search-icon').css('border-radius', '0 25px 25px 0');
			$('#search-rank').attr('hidden', 'hidden');
		}
	});
	
	// navbar 검색 TOP 5 항목에 마우스 올리거나 내리면 색상 변경, 선택한 keyword로 검색하기
	$('#search-rank-list-keyword1, #search-rank-list-keyword2, #search-rank-list-keyword3, #search-rank-list-keyword4').on({
		mouseenter: function() {
			$(this).css('background-color', 'rgb(233, 236, 239)');
		},
		mouseleave: function() {
			$(this).css('background-color', 'white');
		},
		mousedown: function(e) {
			e.preventDefault();
			var keyword = $(this).text();
			$('#navbar-search-input').val(keyword);
			$('#search-form').submit();
		}
	});
	
	// navbar 검색 TOP 5 항목에 마우스 올리거나 내리면 색상 변경, 선택한 keyword로 검색하기(제일 아래 키워드 mouseenter시 검색창 하단 형태가 변형되는 문제 때문에 따로 border-radius 적용)
	$('#search-rank-list-keyword5').on({
		mouseenter: function() {
			$(this).css('background-color', 'rgb(233, 236, 239)');
			$(this).css('border-radius', '0 0 15px 15px');
		},
		mouseleave: function() {
			$(this).css('background-color', 'white');
		},
		mousedown: function(e) {
			e.preventDefault();
			var keyword = $(this).text();
			$('#navbar-search-input').val(keyword);
			$('#search-form').submit();
		}
	});
	
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
		case 'team/help/main':
			$(function() {
				$('#nav-help-underline').addClass('active').animate({width: '100%'}, 600);
			});
			break;
	}
	
	// 현재 각 상품 detail 페이지인 경우만 navbar1에서 product_name 표시
	var splitUrl1 = splitUrl.split('?');
	var splitUrl2 = splitUrl1[0];
	
	if ((splitUrl2 == 'team/product/webtoon/get') || (splitUrl2 == 'team/product/webnovel/get') || (splitUrl2 == 'team/product/book/get')) {
		$('#navbar-product').attr('hidden', 'hidden');
	} else {
		$('#navbar-product').removeAttr('hidden');
	}
	
	// top 5 carousel의 첫번째 항목의 class에 active를 추가함(active가 딱 1개인 경우만 carousel이 동작하는데, carousel을 c:forEach로 생성시켰기 때문에 active를 1개만 줄 수 없어서 작성함)
	$('.carousel-inner div').filter(':first').addClass('active');
	
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
	
	// ADMIN 웹툰 삭제
	$('#webtoon-remove-btn').click(function(){
		if (confirm("삭제 하시겠습니까?")) {
			$('#webtoon-modify-form')
			.attr('action', getContextPath() + "/product/webtoon/remove")
			.submit();
		}
	});
	
	// ADMIN 웹소설 삭제
	$('#webnovel-remove-btn').click(function(){
		if (confirm("삭제 하시겠습니까?")) {
			$('#webnovel-modify-form')
			.attr('action', getContextPath() + "/product/webnovel/remove")
			.submit();
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
	
});