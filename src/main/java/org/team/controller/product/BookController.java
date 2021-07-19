package org.team.controller.product;

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
import org.team.domain.product.ProductVO;
import org.team.service.product.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/product/book/*")
@AllArgsConstructor
@Log4j
public class BookController {

	private BookService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("***book list method***");
		
		List<ProductVO> list = service.getList();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/get")
	public void get(@RequestParam Long id, Model model) {
		log.info("***book get method***");
		
		ProductVO vo = service.get(id);
		
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
		
		log.info(product.getProduct_category());
		log.info(product.getProduct_genre());
		log.info(product.getProduct_name());
		log.info(product.getWriter_name());
		
		service.register(product, file1, file2);
		
		rttr.addFlashAttribute("result", product.getId());
		
		return "redirect:/product/book/list";
	}
	
	@PostMapping("/modify")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(ProductVO product, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, RedirectAttributes rttr) {
		log.info("***book modify method***");
		
		boolean success = service.modify(product, file1, file2);
		
		if (success) {
			rttr.addFlashAttribute("modify", product.getProduct_name());
		}
		
		return null;
	}
	
}
