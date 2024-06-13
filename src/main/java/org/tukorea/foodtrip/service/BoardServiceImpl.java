package org.tukorea.foodtrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;

	@Autowired
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	public void addBoard(BoardVO boardVO) throws Exception {
		boardDAO.add(boardVO);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public BoardVO readBoard(Long boardId) throws Exception {
		boardDAO.viewUpdate(boardId);
		return boardDAO.read(boardId);
	}

	public void deleteBoard(Long boardId) throws Exception {
		boardDAO.delete(boardId);
	}

	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}

	public List<BoardVO> readListBoard() throws Exception {
		return boardDAO.readList();
	}

	public List<BoardVO> getPopularBoards() throws Exception {
		return boardDAO.selectPopularBoards();
	}

	public List<BoardVO> getRecentBoards() throws Exception {
		return boardDAO.selectRecentBoards();
	}

	public List<BoardVO> getBoardsByCategoryService(String category) throws Exception {
		return boardDAO.getBoardsByCategory(category);
	}

	
}
