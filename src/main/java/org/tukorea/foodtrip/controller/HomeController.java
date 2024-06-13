package org.tukorea.foodtrip.controller;


import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BoardService boardService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginGet() throws Exception {
		logger.info(" /LogIN URL GET method called. then forward user_login.jsp.");
		return "user/user_login";
	}
	
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(HttpSession session, Locale locale, Model model) {
	    logger.info("Welcome home! ");

	    String nickname = (String) session.getAttribute("nickname");
	    String userId = (String) session.getAttribute("userId");
	    model.addAttribute("nickname", nickname);
	    model.addAttribute("userId", userId);

	    try {
	        List<BoardVO> popularBoards = boardService.getPopularBoards();
	        model.addAttribute("popularBoards", popularBoards);

	        List<BoardVO> recentBoards = boardService.getRecentBoards();
	        model.addAttribute("recentBoards", recentBoards);
	    } catch (Exception e) {
	        // 예외 처리
	        logger.error("Error fetching popular or recent boards: {}", e.getMessage());
	    }

	    return "home"; 
	}
	
}
