package com.ezen.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.service.BoardService;
import com.ezen.board.service.ReplyService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	ReplyService replyService;

	@GetMapping("list")
	public String boardList(Model model) {

		boardService.getBoardList(model);

		return "/boards/list";
	}

	@GetMapping("detail")
	public String boardDetail(Model model, int board_id) {

		boardService.getBoardDetail(model, board_id);
		replyService.getReplyList(model, board_id);

		return "/boards/detail";
	}

	@GetMapping("write")
	public String boardWriteForm() {
		return "/boards/write";
	}

	@PostMapping("write")
	public String boardWrite(BoardDTO dto, RedirectAttributes attributes) {

		int result = boardService.write(dto);

		if (result == 1) {
			attributes.addAttribute("result", 1);
			return "redirect:/list";
		} else {
			attributes.addAttribute("result", 0);
			return "redirect:/write";
		}

	}

	@GetMapping("update")
	public String boardUpdateForm(Model model, int board_id) {

		boardService.updateForm(model, board_id);

		return "/boards/update";
	}

	@PostMapping("update")
	public String boardUpdate(BoardDTO dto, RedirectAttributes attributes) {
		int result = boardService.update(dto);

		if (result == 1) {
			attributes.addAttribute("board_id", dto.getBoard_id());
			return "redirect:/detail";
		} else {
			attributes.addAttribute("board_id", dto.getBoard_id());
			attributes.addAttribute("result", 0);
			return "redirect:/update";
		}
	}

	@PostMapping("delete")
	public String boardDelete() {

		return "redirect:/list";
	}
}
