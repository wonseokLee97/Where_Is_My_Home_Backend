package com.ssafy.happyhouse.board.model.service;

import java.util.List;

import com.ssafy.happyhouse.board.model.dto.BoardDto;
import com.ssafy.happyhouse.board.model.dto.BoardParameterDto;
import com.ssafy.happyhouse.board.model.dto.CommentDto;
import com.ssafy.happyhouse.util.PageNavigation;


public interface BoardService {
	
	public boolean writeArticle(BoardDto boardDto) throws Exception;
	public List<BoardDto> listArticle(BoardParameterDto boardParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception;
	public BoardDto getArticle(int articleno) throws Exception;
	public void updateHit(int articleno) throws Exception;
	public boolean modifyArticle(BoardDto boardDto) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
	public boolean writeComment(CommentDto CommentDto) throws Exception;
	public boolean modifyComment(CommentDto commentDto) throws Exception;
	public boolean deleteComment(int commentNo) throws Exception;
	
}
