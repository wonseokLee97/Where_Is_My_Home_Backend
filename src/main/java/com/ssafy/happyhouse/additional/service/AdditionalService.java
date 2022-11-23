package com.ssafy.happyhouse.additional.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.additional.model.dto.Store;
import com.ssafy.happyhouse.additional.model.dto.StoreInfo;

public interface AdditionalService {

	List<StoreInfo> getStoreInfo(Map<String, Object> map) throws SQLException;
	List<Store> getStoreList(Map<String, Object> map) throws SQLException;

	List<HashMap<String, Object>> getFavoriteApts(String userId) throws SQLException;
	int isFavoriteApt(Map<String, Object> map) throws SQLException;
	int addFavoriteApt(Map<String, Object> map) throws SQLException;
	int removeFavoriteApt(Map<String, Object> map) throws SQLException;
	
}
