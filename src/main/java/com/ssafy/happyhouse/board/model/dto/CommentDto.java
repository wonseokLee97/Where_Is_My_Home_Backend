package com.ssafy.happyhouse.board.model.dto;

import io.swagger.annotations.ApiModelProperty;
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
public class CommentDto {
	@ApiModelProperty(value = "댓글 번호")
	private int commentno;
	@ApiModelProperty(value = "글 번호")
	private int articleno;
	@ApiModelProperty(value = "작성자 아이디")
	private String userid;
	@ApiModelProperty(value = "댓글 내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regtime;
}
