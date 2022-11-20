package com.ssafy.happyhouse.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.board.model.dto.Board;
import com.ssafy.happyhouse.board.model.dto.BoardParameter;
import com.ssafy.happyhouse.board.model.dto.Comment;
import com.ssafy.happyhouse.board.model.service.BoardService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping
	public ResponseEntity<String> writeArticle(@RequestBody Board board) throws Exception {
		logger.info("writeArticle - 호출");
		if (boardService.writeArticle(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public ResponseEntity<List<Board>> listArticle(BoardParameter boardParameter) throws Exception {
		logger.info("listArticle - 호출 {}", boardParameter);
		return new ResponseEntity<List<Board>>(boardService.listArticle(boardParameter), HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public ResponseEntity<Integer> getArticleCount(BoardParameter boardParameter) throws Exception {
		logger.info("listArticle - 호출 {}", boardParameter);
		return new ResponseEntity<Integer>(boardService.getTotalCount(boardParameter), HttpStatus.OK);
	}
	
	@GetMapping("/{articleno}")
	public ResponseEntity<Board> getArticle(@PathVariable("articleno") int articleno) throws Exception {
		logger.info("getArticle - 호출 : " + articleno);
		boardService.updateHit(articleno);
		return new ResponseEntity<Board>(boardService.getArticle(articleno), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody Board boardDto) throws Exception {
		logger.info("modifyArticle - 호출 {}", boardDto);
		if (boardService.modifyArticle(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@DeleteMapping("/{articleno}")
	public ResponseEntity<String> deleteArticle(@PathVariable("articleno") int articleno) throws Exception {
		logger.info("deleteArticle - 호출");
		if (boardService.deleteArticle(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/comment")
	public ResponseEntity<String> writeComment (@RequestBody Comment Comment) throws Exception {
		logger.info("writeComment - 호출");
		if (boardService.writeComment(Comment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@PutMapping("/comment")
	public ResponseEntity<String> modifyComment (@RequestBody Comment Comment) throws Exception {
		logger.info("updateComment - 호출");
		if (boardService.modifyComment(Comment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/{commentno}")
	public ResponseEntity<String> deleteComment (@PathVariable("commentno") int commentNo) throws Exception {
		logger.info("writeComment - 호출 : ");
		if (boardService.deleteComment(commentNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
}




