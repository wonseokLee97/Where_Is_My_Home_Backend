package com.ssafy.happyhouse.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.board.model.dto.BoardDto;
import com.ssafy.happyhouse.board.model.dto.BoardParameterDto;
import com.ssafy.happyhouse.board.model.dto.CommentDto;
import com.ssafy.happyhouse.board.model.mapper.BoardMapper;
import com.ssafy.happyhouse.util.PageNavigation;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public boolean writeArticle(BoardDto boardDto) throws Exception {
		if(boardDto.getSubject() == null || boardDto.getContent() == null) {
			throw new Exception();
		}
		return boardMapper.writeArticle(boardDto) == 1;
	}

	@Override
	public List<BoardDto> listArticle(BoardParameterDto boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);
		return boardMapper.listArticle(boardParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = boardMapper.getTotalCount(boardParameterDto);//총글갯수  269
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / boardParameterDto.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = boardParameterDto.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < boardParameterDto.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public BoardDto getArticle(int articleno) throws Exception {
		return boardMapper.getArticle(articleno);
	}
	
	@Override
	public void updateHit(int articleno) throws Exception {
		boardMapper.updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean modifyArticle(BoardDto boardDto) throws Exception {
		return boardMapper.modifyArticle(boardDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int articleno) throws Exception {
		return boardMapper.deleteArticle(articleno) == 1;
	}

	@Override
	public boolean writeComment(CommentDto commentDto) throws Exception {
		if(commentDto.getContent() == null) {
			throw new Exception();
		}
		return boardMapper.writeComment(commentDto) == 1;
	}
	
	@Override
	public boolean modifyComment(CommentDto commentDto) throws Exception {
		return boardMapper.modifyComment(commentDto) == 1;
	}

	@Override
	public boolean deleteComment(int commentNo) throws Exception {
		return boardMapper.deleteComment(commentNo) == 1;
	}

	@Override
	public List<BoardDto> searchTitle(String subject) throws Exception {
		return boardMapper.searchTitle(subject);
	}

	@Override
	public List<BoardDto> searchWriter(String writer) throws Exception {
		return boardMapper.searchWriter(writer);
	}

}