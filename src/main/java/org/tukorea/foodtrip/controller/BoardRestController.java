package org.tukorea.foodtrip.controller;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.service.BoardService;

@RestController
@RequestMapping("/board/rest")
public class BoardRestController {
	
	@Autowired
	private BoardService boardService;
		
		private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
		
		  @RequestMapping(value = "/{boardId}", method = RequestMethod.GET)
		    public ResponseEntity<BoardVO> readBoard(@PathVariable Long boardId) throws Exception {
		    	BoardVO board = boardService.readBoard(boardId);
		    	
				logger.info(" /board/rest/{boardId} REST-API GET method called. then readBoard method executed.");
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
				headers.set("My-Header", "MyHeaderValue");
				return new ResponseEntity<BoardVO>(board, headers, HttpStatus.OK);
		    }
		  
		  @RequestMapping(method = RequestMethod.POST)
			public String createBpardPost( @RequestBody BoardVO boardVO) throws Exception {
				boardService.addBoard(boardVO);

				logger.info(boardVO.toString());
				logger.info(" /board/rest/ REST-API POST method called. then createBoardPost method executed.");
				return "OK";
			}
}
