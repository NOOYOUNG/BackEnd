package com.board.main.service;

import java.util.List;

import com.board.main.domain.BoardDTO;
import com.board.main.paging.Criteria;

public interface BoardService {
	public boolean registerBoard(BoardDTO params);
	public BoardDTO getBoardDetail(Long idx);
	public boolean deleteBoard(Long idx);
	public List<BoardDTO> getBoardList(BoardDTO params);

}
