package org.tukorea.foodtrip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tukorea.foodtrip.domain.UserVO;
import org.tukorea.foodtrip.service.UserService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
    private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String viewBoard(@PathVariable("userId") String userId, Model model) throws Exception {
		UserVO userVO = userService.readUser(userId);
		model.addAttribute("user", userVO);
		return "mypage/mypage";
	}

}
