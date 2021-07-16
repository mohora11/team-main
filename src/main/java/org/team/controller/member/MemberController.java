package org.team.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.team.domain.member.MemberVO;
import org.team.service.member.MemberService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@AllArgsConstructor
@Log4j
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@GetMapping("/login")
	public void login() {
		log.info("***member login method***");
	}
	
	@GetMapping("/signup")
	public void signup() {
		log.info("***member signup method***");
	}
	
	@PostMapping("/signup")
	public String signupPost(MemberVO vo, RedirectAttributes rttr) {
		log.info(vo);
		
		boolean ok = service.insert(vo);
		
		if (ok) {
			return "redirect:/main";
		} else {
			return "redirect:/member/signup?error";
		}
	} 
}
