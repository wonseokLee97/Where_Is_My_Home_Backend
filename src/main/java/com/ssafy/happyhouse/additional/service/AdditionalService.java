package com.ssafy.happyhouse.additional.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.additional.model.dto.Store;
import com.ssafy.happyhouse.additional.model.dto.StoreInfo;

public interface AdditionalService {

	List<StoreInfo> getStoreInfo(Map<String, Object> map) throws SQLException;
	List<Store> getStoreList(Map<String, Object> map) throws SQLException;
	
}
