package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public void list(Model model) {
		model.addAttribute("boards", boardMapper.getAll());
	}

	@Override
	public boolean detail(Model model, int board_id) {
		BoardDTO boardDTO = boardMapper.get(board_id);

		if (boardDTO != null) {
			model.addAttribute("board", boardDTO);

			return true;

		} else {
			return false;
		}
	}

	/** insert 성공시 테이블 pk(board_id)를 반환, 실패시 0을 반환 */
	@Override
	public int write(BoardDTO dto) {
		int result = boardMapper.insert(dto);

		if (result == 1) {
			return dto.getBoard_id();
		} else {
			return result;
		}
	}
}
