package com.ssafy.happyhouse.additional.model.dto;

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
public class Store {

	private String categoryMain;
	private String storeName;
	private String lng;
	private String lat;
	private String distance;
	
}
