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
import org.team.service.product.WebtoonService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/product/webtoon/*")
@AllArgsConstructor
@Log4j
public class WebtoonController {

	private WebtoonService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("***webtoon list method***");
		
		List<ProductVO> list = service.getList();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/get")
	public void get(@RequestParam Long id, Model model) {
		log.info("***webtoon get method***");
		
		ProductVO vo = service.get(id);
		
		model.addAttribute("webtoon", vo);
	}
	
	@GetMapping("/detail")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public void detail(@RequestParam Long id, Model model) {
		log.info("***book detail method***");
		
		ProductVO vo = service.getFile(id);
		
		model.addAttribute("webtoon", vo);
	}
	
	@GetMapping("/modify")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void getModify(@RequestParam Long id, Model model) {
		log.info("***webtoon get/modify method***");
		
		ProductVO vo = service.get(id);
		
		model.addAttribute("webtoon", vo);
	}
	
	@PostMapping("/register")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(ProductVO product, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, RedirectAttributes rttr) {
		log.info("***webtoon register method***");
		
		service.register(product, file1, file2);
		
		rttr.addFlashAttribute("webtoonRegister", product.getProduct_name());
		
		return "redirect:/product/webtoon/list";
	}
	
	@PostMapping("/modify")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(ProductVO product, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, RedirectAttributes rttr) {
		log.info("***webtoon modify method***");
		
		ProductVO vo = service.get(product.getId());
		
		boolean success = service.modify(product, file1, file2);
		
		if (success) {
			rttr.addFlashAttribute("webtoonBeforeModify", vo);
		}
		
		return "redirect:/product/webtoon/list";
	}
	
	@PostMapping("/remove")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(@RequestParam Long id, RedirectAttributes rttr) {
		log.info("***webtoon remove method***");
		
		ProductVO vo = service.get(id);
		
		boolean success = service.remove(id);
		
		if (success) {
			rttr.addFlashAttribute("webtoonRemove", vo.getProduct_name());
		}
		
		return "redirect:/product/webtoon/list";
	}
}
