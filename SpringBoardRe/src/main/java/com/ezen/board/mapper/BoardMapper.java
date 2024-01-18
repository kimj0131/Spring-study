package com.ezen.board.mapper;

import java.util.List;

import com.ezen.board.dto.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> getAll();
	
	List<BoardDTO> getAllWithReplyCount();
	
	// db에서 BoardDTO 형식으로 꺼낸다
	BoardDTO get(int board_id);
	
	int insert(BoardDTO dto);
	
	int currId();
}
