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
public class Qna {
	private int articleNo;
	private boolean state;
	private String userId;
	private String subject;
	private String content;
	private String regtime;
	private String comment;
}