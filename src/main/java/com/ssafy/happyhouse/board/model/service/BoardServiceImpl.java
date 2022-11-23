package com.ssafy.happyhouse.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.board.model.dto.Board;
import com.ssafy.happyhouse.board.model.dto.BoardParameter;
import com.ssafy.happyhouse.board.model.dto.Comment;
import com.ssafy.happyhouse.board.model.dto.Qna;
import com.ssafy.happyhouse.board.model.dto.QnaParameter;
import com.ssafy.happyhouse.board.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public boolean writeArticle(Board board) throws Exception {
		if(board.getSubject() == null || board.getContent() == null) {
			throw new Exception();
		}
		return boardMapper.writeArticle(board) == 1;
	}

	@Override
	public List<Board> listArticle(BoardParameter boardParameter) throws Exception {
		int start = boardParameter.getPg() == 0 ? 0 : (boardParameter.getPg() - 1) * boardParameter.getSpp();
		boardParameter.setStart(start);
		return boardMapper.listArticle(boardParameter);
	}

	@Override
	public int getTotalCount(BoardParameter boardParameter) throws SQLException {
		return boardMapper.getTotalCount(boardParameter);
	}

	@Override
	public Board getArticle(int articleno) throws Exception {
		return boardMapper.getArticle(articleno);
	}
	
	@Override
	public void updateHit(int articleno) throws Exception {
		boardMapper.updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean modifyArticle(Board board) throws Exception {
		return boardMapper.modifyArticle(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int articleno) throws Exception {
		return boardMapper.deleteArticle(articleno) == 1;
	}

	@Override
	public boolean writeComment(Comment comment) throws Exception {
		if(comment.getContent() == null) {
			throw new Exception();
		}
		return boardMapper.writeComment(comment) == 1;
	}
	
	@Override
	public boolean modifyComment(Comment comment) throws Exception {
		return boardMapper.modifyComment(comment) == 1;
	}

	@Override
	public boolean deleteComment(int commentNo) throws Exception {
		return boardMapper.deleteComment(commentNo) == 1;
	}

	@Override
	public List<Board> searchTitle(String subject) throws Exception {
		return boardMapper.searchTitle(subject);
	}

	@Override
	public List<Board> searchWriter(String writer) throws Exception {
		return boardMapper.searchWriter(writer);
	}

	@Override
	public List<Qna> listQna(QnaParameter qnaParameter) throws Exception {
		int start = qnaParameter.getPg() == 0 ? 0 : (qnaParameter.getPg() - 1) * qnaParameter.getSpp();
		qnaParameter.setStart(start);
		return boardMapper.listQna(qnaParameter);
	}

}