package org.team.controller.member;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.team.domain.member.Criteria;
import org.team.domain.member.MemberVO;
import org.team.domain.product.ProductVO;
import org.team.security.domain.CustomUser;
import org.team.service.member.MemberService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@AllArgsConstructor
@Log4j
public class MemberController {
	
	
	@RequestMapping("/pay")
	public void pay() {
		
	}
	
	@RequestMapping("/fail")
	public void fail() {
		
	}
	
	@RequestMapping("/cancel")
	public void cancel() {
		
	}
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@GetMapping("/login")
	public void login() {
		log.info("***member login method***");
	}
	
	@GetMapping("/logout")
	public void logout() {
		log.info("***member logout method***");
	}
	
	@GetMapping("/signup")
	public void signup(Criteria cri) {
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
	@GetMapping("/info")
	@PreAuthorize("isAuthenticated()")
	public void info(Criteria cri, Principal principal, Model model) {
		log.info(principal.getName());
	
		MemberVO member = service.read(principal.getName());
		
		model.addAttribute("member",member);
	}
	
	@PostMapping("/modify")
	@PreAuthorize("principal.username == #vo.userid")
	public String modify(MemberVO vo, RedirectAttributes rttr, Authentication auth, String oldPassword) {
		boolean ok = service.modify(vo, oldPassword);
		
		if (ok) {
			rttr.addAttribute("status", "success");
			// session의 authentication 을 수정
			CustomUser user = (CustomUser) auth.getPrincipal();
			user.setMember(vo);
		} else {
			rttr.addAttribute("status", "error");
		}
		return "redirect:/member/info";
	}
	
	@PostMapping("/remove")
	@PreAuthorize("principal.username == #vo.userid")
	public String remove(MemberVO vo, RedirectAttributes rttr, HttpServletRequest req, String oldPassword) throws ServletException {
		boolean ok = service.remove(vo, oldPassword);
		
		if (ok) {
			req.logout();
			return "redirect:/main";
		} else {
			rttr.addAttribute("status", "error");
			return "redirect:/member/info";
		}
	}
	
	@GetMapping("/dup")
	@ResponseBody
	public ResponseEntity<String> duplicate(String id) {
		log.info("duplicate method");
		
		// 서비스 일 시키고
		MemberVO vo = service.read(id);
		
		if (vo == null) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<> ("exist", HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/likes")
	@PreAuthorize("isAuthenticated()")
	public void likes(@RequestParam("userid") String userid, Model model) {
		List<ProductVO> list = service.getLikes(userid);
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/likesWebtoon")
	@PreAuthorize("isAuthenticated()")
	public void likesWebtoon(@RequestParam("userid") String userid, Model model) {
		List<ProductVO> webtoon = service.getWebtoonLikes(userid);
		
		model.addAttribute("webtoon", webtoon);
	}
	
	@GetMapping("/likesWebnovel")
	@PreAuthorize("isAuthenticated()")
	public void likesWebnovel(@RequestParam("userid") String userid, Model model) {
		List<ProductVO> webnovel = service.getWebnovelLikes(userid);
		
		model.addAttribute("webnovel", webnovel);
	}
	
	@GetMapping("/likesBook")
	@PreAuthorize("isAuthenticated()")
	public void likesBook(@RequestParam("userid") String userid, Model model) {
		List<ProductVO> book = service.getBookLikes(userid);
		
		model.addAttribute("book", book);
	}
}
