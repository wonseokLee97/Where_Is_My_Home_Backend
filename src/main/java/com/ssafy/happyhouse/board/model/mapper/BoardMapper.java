package com.ssafy.happyhouse.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.board.model.dto.Board;
import com.ssafy.happyhouse.board.model.dto.BoardParameter;
import com.ssafy.happyhouse.board.model.dto.Comment;


@Mapper
public interface BoardMapper {
	
	public int writeArticle(Board board) throws SQLException;
	public List<Board> listArticle(BoardParameter boardParameter) throws SQLException;
	public int getTotalCount(BoardParameter boardParameter) throws SQLException;
	public Board getArticle(int articleno) throws SQLException;
	public void updateHit(int articleno) throws SQLException;
	public int modifyArticle(Board board) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;
	public int writeComment(Comment comment) throws Exception;
	public int modifyComment(Comment comment) throws Exception;
	public int deleteComment(int commentNo) throws Exception;
	public List<Board> searchTitle(String subject);
	public List<Board> searchWriter(String writer);
	
}