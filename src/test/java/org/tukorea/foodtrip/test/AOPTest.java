package org.tukorea.foodtrip.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.persistence.BoardDAO;
import org.tukorea.foodtrip.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class AOPTest {
	 @Autowired
	 private BoardService boardService;
	 

	   
	    @Test
	    public void testAop2() throws Exception {
	        // AOP가 적용된 메소드를 호출합니다.
	    	BoardVO vo;
	       vo=boardService.readBoard((long) 1);
	       System.out.println(vo);
	    }
}
