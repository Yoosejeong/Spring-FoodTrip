package org.tukorea.foodtrip.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.foodtrip.domain.UserVO;
import org.tukorea.foodtrip.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/join" }, method = RequestMethod.GET)
	public String createUserGet() throws Exception {
		logger.info(" /JOIN URL GET method called. then forward user_join.jsp.");
		return "user/user_join";
	}

	@RequestMapping(value = { "/join" }, method = RequestMethod.POST)
	public String createUserPost(@ModelAttribute("user") UserVO vo, Model model) throws Exception {
		  if (userService.isUserIdExists(vo.getUserId())) {
	            model.addAttribute("error", "아이디가 이미 존재합니다.");
	            return "user/user_join"; // 회원가입 페이지로 이동
	        }
	        if (userService.isNicknameExists(vo.getNickname())) {
	            model.addAttribute("error", "닉네임이 이미 존재합니다.");
	            return "user/user_join"; // 회원가입 페이지로 이동
	        }
		userService.joinUser(vo);
		logger.info(vo.toString());
		logger.info(" /join URL POST method called. then createUser method executed.");
		return "redirect:/user/join";
	}



	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginPost(@RequestParam("userId") String userId, @RequestParam("passwd") String passwd, HttpSession session) throws Exception {

		String path = "";

		UserVO vo = new UserVO();

		vo.setUserId(userId);
		vo.setPasswd(passwd);

		int result = userService.loginUser(vo);

		if (result == 1) {
			 UserVO userInfo = userService.readUser(userId);
			 session.setAttribute("userId", userId);
			 session.setAttribute("nickname", userInfo.getNickname());
			   path = "redirect:/home";
		} else {
			path = "/user/user_login";
		}

		return path;

	}
	
	@RequestMapping(value="/drop/{userId}", method = RequestMethod.GET)
	public String dropUser(@PathVariable("userId")String userId)throws Exception{
		System.out.println("Deleting user with ID: " + userId);
		userService.deleteUser(userId);
		return "redirect:/user/join";
	}
}