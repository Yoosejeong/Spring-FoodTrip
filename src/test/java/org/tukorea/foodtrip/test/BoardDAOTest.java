package org.tukorea.foodtrip.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardDAOTest {

	@Autowired
	private BoardDAO dao;
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testReadList() throws Exception {
		List<BoardVO> voList;
		voList = dao.readList();
		for (BoardVO bvo : voList) {
			logger.info(bvo.toString());
		}
	
		}
		
	@Test
	public void testReadByid() throws Exception {
		BoardVO vo;
		vo = dao.read((long) 1);

		logger.info(vo.toString());
	}	
	
	@Test
	public void testCategoryList() throws Exception{
		List<BoardVO> voList;
		voList = dao.getBoardsByCategory("한식");
		for (BoardVO bvo : voList) {
			logger.info(bvo.toString());
		}
	}
}

