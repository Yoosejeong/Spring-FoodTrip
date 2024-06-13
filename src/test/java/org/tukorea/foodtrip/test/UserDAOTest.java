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
import org.tukorea.foodtrip.domain.UserVO;
import org.tukorea.foodtrip.persistence.BoardDAO;
import org.tukorea.foodtrip.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserDAOTest {
	@Autowired
	private UserDAO dao;
	private static Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

	@Test
	public void testJoin() throws Exception {
		try {
			UserVO userVO = new UserVO();
			userVO.setUserId("testUser");
			userVO.setPasswd("testpasswd");
			userVO.setEmail("test@naver.com");
			userVO.setPhone("01011112222");
			userVO.setNickname("testNickname");

			dao.join(userVO);
		} catch (Exception e) {
			logger.error("Exception in testJoin: ", e);
		}
	}

	@Test
	    public void testReadByid() throws Exception {
	     try {   
	        UserVO userVO = dao.read("sj");
	        logger.info(userVO.toString());
	    }catch(Exception e) {
	    	logger.error("Exception in sj : ", e);
	    }
	}
	@Test
	public void testReadList() throws Exception {
		List<UserVO> voList;
		voList = dao.readList();
		for (UserVO bvo : voList) {
			logger.info(bvo.toString());
		}
	}

	/**
	@Test
	public void testDelete() throws Exception{
		dao.delete("droptest");		
	
	}

*/
}
