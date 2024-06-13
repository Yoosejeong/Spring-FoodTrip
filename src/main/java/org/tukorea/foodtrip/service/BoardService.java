package org.tukorea.foodtrip.service;

import java.util.List;

import org.tukorea.foodtrip.domain.BoardVO;

public interface BoardService {
	public void addBoard(BoardVO boardVO) throws Exception;

	public BoardVO readBoard(Long boardId) throws Exception;

	public void deleteBoard(Long boardId) throws Exception;

	public void updateBoard(BoardVO boardVO) throws Exception;

	public List<BoardVO> readListBoard() throws Exception;

	public List<BoardVO> getPopularBoards() throws Exception;

	public List<BoardVO> getRecentBoards() throws Exception;

	public List<BoardVO> getBoardsByCategoryService(String category) throws Exception;

}