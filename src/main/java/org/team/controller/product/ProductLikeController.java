package org.team.controller.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team.domain.product.ProductLikeVO;
import org.team.service.product.LikeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product/likes")
@AllArgsConstructor
public class ProductLikeController {
	
	private LikeService service;

	@PostMapping("/like")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> like(@RequestBody ProductLikeVO vo) {
		int cnt = service.like(vo);
		
		if (cnt == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/dislike")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> dislike(@RequestBody ProductLikeVO vo) {
		int cnt = service.dislike(vo);
		
		if (cnt == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
