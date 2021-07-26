package org.team.controller.product;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.team.domain.member.MemberVO;
import org.team.domain.product.ProductLikeVO;
import org.team.domain.product.ProductVO;
import org.team.service.product.BookService;
import org.team.service.product.ProductLikeService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/product/book/*")
@AllArgsConstructor
@Log4j
public class BookController {

	private BookService service;
	private ProductLikeService likeService;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("***book list method***");
		
		List<ProductVO> list = service.getList();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/get")
	public void get(@RequestParam Long id, Model model, Principal principal) {
		log.info("***book get method***");
		
		ProductVO vo = service.get(id);
		model.addAttribute("book", vo);
		
		// 해당 상품을 읽어올 때 현재 사용자가 해당 상품에 좋아요를 눌렀었는지 확인
		if (principal != null) { // 로그인 상태가 아니면 아래의 principal.getName()에서 NullPointerException이 발생하므로 로그인 상태인 경우만
			ProductLikeVO lvo = likeService.get(id.toString(), principal.getName());
			model.addAttribute("like", lvo);
		}
		
	}
	
	@GetMapping("/detail")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public void detail(@RequestParam Long id, Model model) {
		log.info("***book detail method***");
		
		ProductVO vo = service.getFile(id);
		// 작품 보기 시 view_cnt값 1증가(조회수)
		service.plusCnt(id);
		
		model.addAttribute("book", vo);
	}
	
	@GetMapping("/modify")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void getModify(@RequestParam Long id, Model model) {
		log.info("***book get/modify method***");
		
		ProductVO vo = service.get(id);
		
		model.addAttribute("book", vo);
	}
	
	@PostMapping("/register")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(ProductVO product, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, RedirectAttributes rttr) {
		log.info("***book register method***");
		
		service.register(product, file1, file2);
		
		rttr.addFlashAttribute("bookRegister", product.getProduct_name());
		
		return "redirect:/product/book/list";
	}
	
	@PostMapping("/modify")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(ProductVO product, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, RedirectAttributes rttr) {
		log.info("***book modify method***");
		
		ProductVO vo = service.get(product.getId());
		
		boolean success = service.modify(product, file1, file2);
		
		if (success) {
			rttr.addFlashAttribute("bookBeforeModify", vo);
		}
		
		return "redirect:/product/book/list";
	}
	
	@PostMapping("/remove")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(@RequestParam Long id, RedirectAttributes rttr) {
		log.info("***book remove method***");
		
		ProductVO vo = service.get(id);
		
		boolean success = service.remove(id);
		
		if (success) {
			rttr.addFlashAttribute("bookRemove", vo.getProduct_name());
		}
		
		return "redirect:/product/book/list";
	}
	
}
