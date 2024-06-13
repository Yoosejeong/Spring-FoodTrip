package org.tukorea.foodtrip.persistence;

import java.util.List;

import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.domain.UserVO;

public interface BoardDAO {
	public void add(BoardVO boardVO) throws Exception;

	public BoardVO read(Long boardId) throws Exception;

	public void delete(Long boardId) throws Exception;

	public void update(BoardVO boardVO) throws Exception;

	public List<BoardVO> readList() throws Exception;

	public void viewUpdate(Long boardId) throws Exception;

	public List<BoardVO> selectPopularBoards() throws Exception;

	public List<BoardVO> selectRecentBoards() throws Exception;

	public List<BoardVO> getBoardsByCategory(String category) throws Exception;

	
}