package com.ezen.board.mapper;

import java.util.List;

import com.ezen.board.dto.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> getBoardList();
	
	BoardDTO getBoardDetail(int board_id);
	
	
	int writeBoard(BoardDTO dto);
	
	int updateBoard(BoardDTO dto);
	
	int deleteBoard(int board_id);
	
}
