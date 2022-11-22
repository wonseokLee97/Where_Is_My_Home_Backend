package com.ssafy.happyhouse.house.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.additional.model.dto.Favorite;
import com.ssafy.happyhouse.house.model.dto.AptDeal;
import com.ssafy.happyhouse.house.model.dto.AptInfo;
import com.ssafy.happyhouse.house.model.dto.DongInfo;

public interface HouseService {
	
	String getDongCode(DongInfo dongInfo) throws SQLException;
	AptInfo getAptInfo(String aptCode) throws SQLException;
	List<AptInfo> getAptInfos(Map<String, Object> map) throws SQLException;
	List<AptInfo> getAptInfosByLngLat(Map<String, Object> map) throws SQLException;
	List<AptDeal> getAptDeals(Map<String, Object> map) throws SQLException;
	int totalAptInfoCount(String dongCode) throws SQLException;
	int totalAptDealCount(Map<String, Object> map) throws SQLException;
	
	List<Favorite> getFavorites(String userId) throws SQLException;
	boolean addFavorite(Map<String, String> map) throws SQLException;
	boolean deleteFavorite(Map<String, String> map) throws SQLException;
	
	List<AptDeal> getFavoriteLatest(String userId) throws SQLException;
	
	List<String> getSido() throws SQLException;
	List<String> getGugun(DongInfo dongInfo) throws SQLException;
	List<String> getDong(DongInfo dongInfo) throws SQLException;
	
}
