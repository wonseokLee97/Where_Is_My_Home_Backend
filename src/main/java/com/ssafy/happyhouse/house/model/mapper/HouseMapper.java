package com.ssafy.happyhouse.house.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.additional.model.dto.Favorite;
import com.ssafy.happyhouse.house.model.dto.AptDeal;
import com.ssafy.happyhouse.house.model.dto.AptInfo;

public interface HouseMapper {

	String getDongCode(Map<String, String> map) throws SQLException;
	AptInfo getAptInfo(String aptCode) throws SQLException;
	List<AptInfo> getAptInfos(Map<String, Object> map) throws SQLException;
	List<AptDeal> getAptDeals(Map<String, Object> map) throws SQLException;
	int totalAptInfoCount(String dongCode) throws SQLException;
	int totalAptDealCount(Map<String, Object> map) throws SQLException;
	
	List<Favorite> getFavorites(String userId) throws SQLException;
	boolean addFavorite(Map<String, String> map) throws SQLException;
	boolean deleteFavorite(Map<String, String> map) throws SQLException;
	
	List<AptDeal> getFavoriteLatest(String userId) throws SQLException;
	
	List<String> getSido() throws SQLException;
	List<String> getGugun(String sidoName) throws SQLException;
	List<String> getDong(String gugunName) throws SQLException;
	
}
