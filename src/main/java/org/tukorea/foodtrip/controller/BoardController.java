package org.tukorea.foodtrip.controller;

import java.time.LocalDateTime;
import java.util.List;

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
import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model) throws Exception {
		List<BoardVO> boardList = boardService.readListBoard();
		model.addAttribute("boardList", boardList);

		return "board/boardlist";
	}
	
	@RequestMapping(value = "/list/{category}", method = RequestMethod.GET)
	public String boardCategorylist(@PathVariable("category")String category,Model model) throws Exception {
		List<BoardVO> boardList = boardService.getBoardsByCategoryService(category);
		model.addAttribute("boardList", boardList);

		return "board/boardlist";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String createBoardForm() {
		return "board/boardwrite";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String createBoard(@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("category") String category, @RequestParam("rating") float rating, HttpSession session)
			throws Exception {

		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/foodtrip/user/login";
		}

		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setUserId(userId);
		boardVO.setCategory(category);
		boardVO.setRating(rating);

		boardService.addBoard(boardVO);

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/{boardId}", method = RequestMethod.GET)
	public String viewBoard(@PathVariable("boardId") Long boardId, Model model) throws Exception {
		BoardVO boardVO = boardService.readBoard(boardId);
		model.addAttribute("board", boardVO);
		return "board/board";
	}

	@RequestMapping(value = "/delete/{boardId}", method = RequestMethod.GET)
	public String deleteBoard(@PathVariable("boardId") Long boardId) throws Exception {
		boardService.deleteBoard(boardId);
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/modify/{boardId}", method = RequestMethod.GET)
	public String modifyBoard(@PathVariable("boardId") Long boardId, Model model) throws Exception {
		BoardVO board = boardService.readBoard(boardId);

		model.addAttribute("board", board);
		return "board/boardmodify";
	}

	@RequestMapping(value = "/modify/{boardId}", method = RequestMethod.POST)
	public String modifyBoard(@ModelAttribute("board") BoardVO boardVO) throws Exception {
		boardService.updateBoard(boardVO);
		logger.info(boardVO.toString());
		return "redirect:/board/list";
	}
	

}