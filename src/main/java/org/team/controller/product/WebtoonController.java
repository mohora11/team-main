package org.team.controller.product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
