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
public class AptDeal extends AptInfo {

	private String floor;
	private String dealAmount;
	
}
