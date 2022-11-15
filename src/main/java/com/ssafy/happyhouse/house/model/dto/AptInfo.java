package com.ssafy.happyhouse.house.model.dto;

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
public class AptInfo {

	private String aptCode;
	private String roadName;
	private String jibun;
	private String apartmentName;
	private String dong;
	private String buildYear;
	private String lng;
	private String lat;
	
}
