package org.team.controller.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team.domain.board.BoardLikeVO;
import org.team.service.board.BoardLikeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/board/likes")
@AllArgsConstructor
public class BoardLikeController {

	private BoardLikeService service;

	@PostMapping("/like")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> like(@RequestBody BoardLikeVO vo) {
		// 좋아요 누를 때, 해당 상품에 해당 사용자가 좋아요를 눌렀다는 기록 남기기(기록 입력)
		int cnt = service.like(vo);
		
		if (cnt == 1) {
			// 해당 게시글의 좋아요 개수 +1
			service.plusCnt(vo);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/cancelLike")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> cancelLike(@RequestBody BoardLikeVO vo) {
		// 좋아요 다시 누를 때, 해당 상품에 해당 사용자가 좋아요를 해제했다는 기록 남기기(기록 삭제)
		int cnt = service.cancelLike(vo);
		
		if (cnt == 1) {
			// 해당 게시글의 좋아요 개수 -1
			service.minusCnt(vo);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/dislike")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> dislike(@RequestBody BoardLikeVO vo) {
		// 싫어요 누를 때, 해당 상품에 해당 사용자가 좋아요를 눌렀다는 기록 남기기(기록 입력)
		int cnt = service.dislike(vo);
		
		if (cnt == 1) {
			// 해당 게시글의 싫어요 개수 +1
			service.displusCnt(vo);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/cancelDislike")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> cancelDislike(@RequestBody BoardLikeVO vo) {
		// 싫어요 다시 누를 때, 해당 상품에 해당 사용자가 좋아요를 해제했다는 기록 남기기(기록 삭제)
		int cnt = service.cancelDislike(vo);
		
		if (cnt == 1) {
			// 해당 게시글의 싫어요 개수 -1
			service.disminusCnt(vo);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
