package com.ezen.board.mapper;

import java.util.List;

import com.ezen.board.dto.ReplyDTO;

public interface ReplyMapper {

	List<ReplyDTO> getReplyList(int board_id);
	
	int writeReply(ReplyDTO dto);
}
