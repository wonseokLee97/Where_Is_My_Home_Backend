package com.ssafy.happyhouse.board.model.dto;

import lombok.ToString;

@ToString
public class QnaParameter {
	
	private int pg;
	private int spp;
	private int start;
	private String key;
	private String word;
	
	public QnaParameter() {
		pg = 1;
		spp = 20;
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		pg = pg == 0 ? 1 : pg;
		this.pg = pg;
	}

	public int getSpp() {
		return spp;
	}

	public void setSpp(int spp) {
		this.spp = spp;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
