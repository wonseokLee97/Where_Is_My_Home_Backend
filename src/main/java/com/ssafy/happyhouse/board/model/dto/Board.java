package com.ssafy.happyhouse.board.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {
	
	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private String regtime;
	private List<Comment> comments;
	
}
