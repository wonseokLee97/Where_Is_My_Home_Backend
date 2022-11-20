package com.ssafy.happyhouse.board.model.dto;

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
public class Comment {
	
	private int commentNo;
	private int articleNo;
	private String userId;
	private String content;
	private String regtime;
	
}
