package com.ezen.board.service;

import org.springframework.ui.Model;

import com.ezen.board.dto.ReplyDTO;

public interface ReplyService {
	
	void getReplyList(Model model, int board_id);
	
	int writeRelpy(ReplyDTO dto);

}
