package com.ssafy.happyhouse.board.model.service;

import java.util.List;

import com.ssafy.happyhouse.board.model.dto.Board;
import com.ssafy.happyhouse.board.model.dto.BoardParameter;
import com.ssafy.happyhouse.board.model.dto.Comment;
import com.ssafy.happyhouse.util.PageNavigation;


public interface BoardService {
	
	public boolean writeArticle(Board boardDto) throws Exception;
	public List<Board> listArticle(BoardParameter boardParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameter boardParameterDto) throws Exception;
	public Board getArticle(int articleno) throws Exception;
	public void updateHit(int articleno) throws Exception;
	public boolean modifyArticle(Board boardDto) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
	public boolean writeComment(Comment CommentDto) throws Exception;
	public boolean modifyComment(Comment commentDto) throws Exception;
	public boolean deleteComment(int commentNo) throws Exception;
	public List<Board> searchTitle(String subject) throws Exception;
	public List<Board> searchWriter(String writer) throws Exception;
	
}
