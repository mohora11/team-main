package org.team.controller.product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
