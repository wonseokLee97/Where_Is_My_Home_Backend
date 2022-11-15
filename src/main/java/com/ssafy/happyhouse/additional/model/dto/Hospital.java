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
public class Hospital {
	private String hospitalName;
	private String address;
	private String tel;
	
}
