package org.tukorea.foodtrip.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.persistence.BoardDAO;
import org.tukorea.foodtrip.persistence.UserDAO;
import org.tukorea.foodtrip.service.BoardService;
import org.tukorea.foodtrip.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ViewUpdateTest {

	@Autowired
	BoardDAO boardDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserService userService;

	

	@Test
	@Transactional
	public void testErrorIncreaseViewCount() {
		Long boardId = (long) 1; // 존재하는 게시글 ID를 사용
	    try {
	        // 게시글 1의 초기 조회수 확인
	        BoardVO initialBoard = boardDAO.read(boardId);
	        int initialViews = initialBoard.getViews();
	        System.out.println("[error] 초기 조회수: " + initialViews);

	        // 게시글 1의 조회수 증가 메서드 호출
	        boardDAO.viewUpdate(boardId);
	        BoardVO updatedBoard = boardDAO.read(boardId);
	        int updatedviews = updatedBoard.getViews();
	        System.out.println("[error] 증가 후 조회수: " + updatedviews);

	        // read에 오류 발생시키기 위해 boardId에 없는 값 99 대입
	        Long errorBoardId = (long) 99;
	        boardDAO.read(errorBoardId); // 존재하지 않는 게시글 조회       
	        //데이터베이스에 확인 시 updatedviews -1 의 값이 들어가있음. 롤백했기때문에 
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("테스트 중 예외 발생");
	    }
	}
	
	@Test
	public void tesIncreaseViewCount() {
		Long boardId = (long) 1; // 존재하는 게시글 ID를 사용
	    try {
	        // 게시글 1의 초기 조회수 확인
	        BoardVO initialBoard = boardDAO.read(boardId);
	        int initialViews = initialBoard.getViews();
	        System.out.println("초기 조회수: " + initialViews);

	        // 게시글 1의 조회수 증가 메서드 호출
	        boardDAO.viewUpdate(boardId);
	        BoardVO updatedBoard = boardDAO.read(boardId);
	        int updatedviews = updatedBoard.getViews();
	        System.out.println("증가 후 조회수: " + updatedviews);
	        //데이터베이스에 확인 시 updatedviews 의 값이 들어가있음. 
	         
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("테스트 중 예외 발생");
	    }
	}
	
}
