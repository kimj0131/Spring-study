package com.ezen.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.mapper.BoardMapper;
import com.ezen.board.mapper.ReplyMapper;
import com.ezen.board.secure.SecureTools;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	@Autowired
	ReplyMapper replyMapper;

	@Override
	public void getBoardList(Model model) {
		List<BoardDTO> boards = boardMapper.getBoardList();
		
		Map<Integer, Integer> replySizes = new HashMap<>();
		
		for (BoardDTO board : boards) {
			int boardId = board.getBoard_id();
			int replySize = replyMapper.getReplyList(boardId).size();
			replySizes.put(boardId, replySize);
		}
		
		model.addAttribute("replySizes", replySizes);
		model.addAttribute("boards", boardMapper.getBoardList());
	}

	@Override
	public void getBoardDetail(Model model, int board_id) {
		model.addAttribute("detail", boardMapper.getBoardDetail(board_id));
	}

	@Override
	public int write(BoardDTO dto) {
		if (dto.getBoard_title() != null && dto.getBoard_content() != null 
				&& dto.getBoard_writer() != null) {
			String hashed = SecureTools.getHashedPassword(dto.getBoard_password());
			dto.setBoard_password(hashed);
			return boardMapper.writeBoard(dto);
		} else {
			return 0;
		}
	}
	
	@Override
	public int updateForm(Model model, int board_id) {
		BoardDTO board = boardMapper.getBoardDetail(board_id);

		if (board == null) {
			return -1;
		}

		model.addAttribute("board", board);

		return 1;
	}
	
	@Override
	public int update(BoardDTO dto) {
		return boardMapper.updateBoard(dto);
	}
}
