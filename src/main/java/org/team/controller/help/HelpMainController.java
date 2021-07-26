package org.team.controller.help;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.team.service.help.HBoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/help/*")
public class HelpMainController {
	
	
	@RequestMapping("/main")
	public void main() {
	
	}
}


