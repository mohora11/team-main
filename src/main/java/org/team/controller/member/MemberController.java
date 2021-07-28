package org.team.controller.member;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.team.SendEmail;
import org.team.domain.member.Criteria;
import org.team.domain.member.MemberVO;
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
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@RequestMapping("/pay")
	public void pay() {
		
	}
	
//	@RequestMapping(value = "/pay", params = "pg_token")
	public String pay(@RequestParam("pg_token") String pgToken) {
		String failUrl = "/member/fail";
		String successUrl = "/member/success";
		
		try {
			
			if (service.approve(pgToken)) {
				log.info("모두 잘됨!!");
				
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("뭔가 이상1111!!");
		}
		
		log.info("뭔가 이상2222!!");
		return null;
	}
	
	@RequestMapping("/fail")
	public void fail() {
		
	}
	
	@RequestMapping("/cancel")
	public void cancel() {
		
	}
	
	@GetMapping("/findid")
	public void findid() {
		log.info("*** findid in ***");
	}
	
	@GetMapping("/findpw")
	public void findpw() {
		log.info("*** findpw in ***");
	}
	
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
	
	@PostMapping("/findid")
	public ResponseEntity<List<String>> findid(@RequestBody MemberVO vo, Model model) {
		log.info("***findid post***");
		log.info(vo);
		
		List<String> userid = new ArrayList<String>();
		
		List<MemberVO> vo2 = service.read2(vo);
		log.info(vo2);
		
		
		
		if(vo2.size() == 0) {
			return new ResponseEntity<List<String>> (HttpStatus.BAD_REQUEST);
		} else {
			for(MemberVO fid : vo2) {
				if(fid.getUsermail().equals(vo.getUsermail())) {
					userid.add(fid.getUserid());
				}
			}
			return new ResponseEntity<List<String>> (userid, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/findpw")
	public ResponseEntity<String> findpw(@RequestBody MemberVO vo) {
		
		log.info(vo);
		
		// 서비스 일 시키고
		List<MemberVO> vo2 = service.read3(vo);
		
		if (!vo2.isEmpty()) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<> ("exist", HttpStatus.OK);
		}
	}
	@PostMapping("/authNumber")
	public void authNumber(MemberVO member, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		HttpSession session = request.getSession();
		
		String idI = request.getParameter("idI");
		String idE = request.getParameter("idE");
		
		log.info(idE);
		
		if(idI == null) {
			
		
			int num = (int) (Math.random()*123);
			
			SendEmail.sendEmail(num, idE);
			
			session.setAttribute("authRandomNumber", num);
			System.out.println(num);
			
			response.getWriter().append("ok1");
			
			
		} else {
			int num = (Integer) session.getAttribute("authRandomNumber");
			int num1 = Integer.parseInt(idI);
			if (num == num1) {
				response.getWriter().append("ok2");
			} else {
				response.getWriter().append("not ok");
			}

		}
		
	}
}
