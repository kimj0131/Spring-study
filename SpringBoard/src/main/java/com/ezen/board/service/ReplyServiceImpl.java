package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.board.dto.ReplyDTO;
import com.ezen.board.mapper.ReplyMapper;
import com.ezen.board.secure.SecureTools;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyMapper replyMapper;

	@Override
	public void getReplyList(Model model, int board_id) {

		model.addAttribute("replies", replyMapper.getReplyList(board_id));
	}

	@Override
	public int writeRelpy(ReplyDTO dto) {
		String hashed = SecureTools.getHashedPassword(dto.getReply_password());
		dto.setReply_password(hashed);
		return replyMapper.writeReply(dto);
	}

}
