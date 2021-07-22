package org.team.controller.help;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.team.domain.help.HelpCriteria;
import org.team.domain.help.HelpPageDTO;
import org.team.domain.help.HelpVO;
import org.team.service.help.HelpService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/help/*")
@AllArgsConstructor
public class HelpController {

	private HelpService service;

	@GetMapping("/list")
	public void list(@ModelAttribute("cri") HelpCriteria cri, Model model) {
		int total = service.getTotal(cri);

		List<HelpVO> list = service.getList(cri);

		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new HelpPageDTO(cri, total));

	}

	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(HelpVO board, @RequestParam("file") MultipartFile file, RedirectAttributes rttr) {

		board.setFileName(file.getOriginalFilename());

		service.register(board, file);

		rttr.addFlashAttribute("result", board.getHno());
		rttr.addFlashAttribute("messageTitle", "등록 성공.");
		rttr.addFlashAttribute("messageBody", board.getHno() + "번 게시물 등록 되었습니다.");

		// /board/list redirect
		return "redirect:/help/list";
	}

	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") HelpCriteria cri, Model model) {

		HelpVO vo = service.get(bno);

		model.addAttribute("board", vo);

	}

	@PostMapping("/modify")
	@PreAuthorize("principal.username == #help.hwriter") // 720p
//	@PreAuthorize("authication.name == #board.writer")// spring.io
	public String modify(HelpVO board, HelpCriteria cri, @RequestParam("file") MultipartFile file,
			RedirectAttributes rttr) {


		boolean success = service.modify(board, file); // 101줄 if(success) 가능

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messagTitle", "수정 성공.");
			rttr.addFlashAttribute("messageBody", "수정 되었습니다.");
		}

		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/help/list";
	}

	@PostMapping("/remove")
	@PreAuthorize("principal.username == #writer") // 720p
	public String remove(Long hno, HelpCriteria cri, RedirectAttributes rttr, String writer) {

		boolean success = service.remove(hno);

		if (success) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messagTitle", "삭제 성공.");
			rttr.addFlashAttribute("messageBody", "삭제 되었습니다.");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/help/list";
	}

	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()") // 673p
	public void register(@ModelAttribute("cri") HelpCriteria cri) {
		// forward함 WEB-INF/views/board/register.jsp
	}

}
