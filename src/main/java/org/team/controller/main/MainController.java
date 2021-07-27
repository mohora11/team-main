package org.team.controller.main;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.team.domain.product.ProductVO;
import org.team.service.main.MainService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/*")
@AllArgsConstructor
@Log4j
public class MainController {
	
	private MainService service;

	@GetMapping("/main")
	public void list(Model model) {
		log.info("***main list method***");
		
		List<ProductVO> list = service.getList();
		List<ProductVO> rank = service.getRank();
		
		model.addAttribute("list", list);
		model.addAttribute("rank", rank);
	}
	
	@RequestMapping("/product/register")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void register() {
		
	}
	
}
