package org.tukorea.foodtrip.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.tukorea.foodtrip.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "org.tukorea.foodtrip.mapper.boardMapper";

	public BoardVO read(Long boardId) throws Exception {

		BoardVO boardVO = sqlSession.selectOne(namespace + ".selectByid", boardId);
		return boardVO;
	}

	public void add(BoardVO boardVO) throws Exception {
		sqlSession.insert(namespace + ".insert", boardVO);
	}

	public void delete(Long boardId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", boardId);
	}

	public void update(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", boardVO);
	}

	public List<BoardVO> readList() throws Exception {
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		boardlist = sqlSession.selectList(namespace + ".selectAll");
		return boardlist;
	}

	public void viewUpdate(Long boardId) {

		sqlSession.update(namespace + ".viewUpdate", boardId);
	}

	public List<BoardVO> selectPopularBoards() throws Exception {
		return sqlSession.selectList(namespace + ".selectPopularBoards");
	}

	public List<BoardVO> selectRecentBoards() throws Exception {
		return sqlSession.selectList(namespace + ".selectRecentBoards");
	}

	public List<BoardVO> getBoardsByCategory(String category) throws Exception {
		return sqlSession.selectList(namespace + ".getBoardByCategory", category);
	}

	
}