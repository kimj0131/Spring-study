package com.ezen.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.board.dto.ReplyDTO;
import com.ezen.board.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	ReplyService replyService;
	
	@PostMapping("reply/write")
	public String writeReply(ReplyDTO dto, int board_id, RedirectAttributes attributes) {
		
		int result = replyService.writeRelpy(dto);
		
		if (result == 1) {
			attributes.addAttribute("board_id", board_id);
			return "redirect:/detail";
		} else {
			attributes.addAttribute("board_id", board_id);
			attributes.addAttribute("result", 0);
			return "redirect:/detail";
		}
	}
	@GetMapping("reply/list")
	public String replyList(Model model, int board_id) {
		replyService.getReplyList(model, board_id);
		
		return "/boards/replyList";
	}
}
