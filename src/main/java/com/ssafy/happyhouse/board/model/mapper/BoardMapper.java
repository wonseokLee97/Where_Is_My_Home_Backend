package com.ssafy.happyhouse.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.board.model.dto.BoardDto;
import com.ssafy.happyhouse.board.model.dto.BoardParameterDto;
import com.ssafy.happyhouse.board.model.dto.CommentDto;


@Mapper
public interface BoardMapper {
	
	public int writeArticle(BoardDto boardDto) throws SQLException;
	public List<BoardDto> listArticle(BoardParameterDto boardParameterDto) throws SQLException;
	public int getTotalCount(BoardParameterDto boardParameterDto) throws SQLException;
	public BoardDto getArticle(int articleno) throws SQLException;
	public void updateHit(int articleno) throws SQLException;
	public int modifyArticle(BoardDto boardDto) throws SQLException;
	public void deleteMemo(int articleno) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;
	public int writeComment(CommentDto commentDto) throws Exception;
}