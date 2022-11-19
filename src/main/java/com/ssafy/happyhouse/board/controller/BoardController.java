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
	
	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeArticle(@RequestBody @ApiParam(value = "게시글 정보.", required = true) Board boardDto) throws Exception {
		logger.info("writeArticle - 호출");
		if (boardService.writeArticle(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Board>> listArticle(@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) BoardParameter boardParameterDto) throws Exception {
		logger.info("listArticle - 호출");
		return new ResponseEntity<List<Board>>(boardService.listArticle(boardParameterDto), HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = Board.class)
	@GetMapping("/{articleno}")
	public ResponseEntity<Board> getArticle(@PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleno) throws Exception {
		logger.info("getArticle - 호출 : " + articleno);
		boardService.updateHit(articleno);
		return new ResponseEntity<Board>(boardService.getArticle(articleno), HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판 글수정", notes = "수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody @ApiParam(value = "수정할 글정보.", required = true) Board boardDto) throws Exception {
		logger.info("modifyArticle - 호출 {}", boardDto);
		if (boardService.modifyArticle(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{articleno}")
	public ResponseEntity<String> deleteArticle(@PathVariable("articleno") @ApiParam(value = "삭제할 글의 글번호.", required = true) int articleno) throws Exception {
		logger.info("deleteArticle - 호출");
		if (boardService.deleteArticle(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "제목 검색", notes = "게시물의 제목을 검색하여 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping("/title/{subject}")
	public ResponseEntity<List<Board>> searchTitle(@PathVariable("subject") @ApiParam(value = "검색할 제목.", required = true) String subject) throws Exception {
		logger.info("searchTitle - 호출");
		return new ResponseEntity<List<Board>>(boardService.searchTitle(subject), HttpStatus.OK);
	}
	
	@ApiOperation(value = "작성자 검색", notes = "작성자를 검색하여 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping("/writer/{writer}")
	public ResponseEntity<List<Board>> searchWriter(@PathVariable("writer") @ApiParam(value = "검색할 작성자.", required = true) String writer) throws Exception {
		logger.info("searchWriter - 호출");
		return new ResponseEntity<List<Board>>(boardService.searchWriter(writer), HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 작성", notes = "새로운 댓글을 작성한다.", response = String.class)
	@PostMapping("/comment")
	public ResponseEntity<String> writeComment (@RequestBody @ApiParam(value = "댓글 정보.", required = true) Comment CommentDto) throws Exception {
		logger.info("writeComment - 호출 : ");
		if (boardService.writeComment(CommentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 수정", notes = "댓글을 수정한다.", response = String.class)
	@PutMapping("/comment")
	public ResponseEntity<String> modifyComment (@RequestBody @ApiParam(value = "댓글 정보.", required = true) Comment CommentDto) throws Exception {
		logger.info("updateComment - 호출 : ");
		if (boardService.modifyComment(CommentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 삭제", notes = "댓글을 삭제한다.", response = String.class)
	@DeleteMapping("/comment/{commentno}")
	public ResponseEntity<String> deleteComment (@PathVariable("commentno") @ApiParam(value = "삭제할 댓글 번호.", required = true) int commentNo) throws Exception {
		logger.info("writeComment - 호출 : ");
		if (boardService.deleteComment(commentNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
}




