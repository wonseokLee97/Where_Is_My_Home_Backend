package com.ssafy.happyhouse.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.board.model.dto.Board;
import com.ssafy.happyhouse.board.model.dto.BoardParameter;
import com.ssafy.happyhouse.board.model.dto.Comment;
import com.ssafy.happyhouse.board.model.dto.Qna;
import com.ssafy.happyhouse.board.model.dto.QnaParameter;

public interface BoardService {
	
	public boolean writeArticle(Board board) throws Exception;
	public List<Board> listArticle(BoardParameter boardParameter) throws Exception;
	public int getTotalCount(BoardParameter boardParameter) throws SQLException;
	public Board getArticle(int articleno) throws Exception;
	public void updateHit(int articleno) throws Exception;
	public boolean modifyArticle(Board board) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
	public boolean writeComment(Comment Comment) throws Exception;
	public boolean modifyComment(Comment comment) throws Exception;
	public boolean deleteComment(int commentNo) throws Exception;
	public List<Board> searchTitle(String subject) throws Exception;
	public List<Board> searchWriter(String writer) throws Exception;
	public List<Qna> listQna(QnaParameter qnaParameter) throws Exception;
}
