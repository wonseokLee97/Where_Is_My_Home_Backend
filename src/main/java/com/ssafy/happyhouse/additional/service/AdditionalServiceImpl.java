package com.ssafy.happyhouse.additional.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.additional.model.dto.Store;
import com.ssafy.happyhouse.additional.model.dto.StoreInfo;
import com.ssafy.happyhouse.additional.model.mapper.AdditionalMapper;

@Service
public class AdditionalServiceImpl implements AdditionalService {
	
	@Autowired
	AdditionalMapper additionalMapper;
	
	@Override
	public List<StoreInfo> getStoreInfo(Map<String, Object> map) throws SQLException {
		return additionalMapper.getStoreInfo(map);
	}
	
	@Override
	public List<Store> getStoreList(Map<String, Object> map) throws SQLException {
		return additionalMapper.getStoreList(map);
	}
	
	@Override
	public List<HashMap<String, Object>> getFavoriteApts(String userId) throws SQLException {
		return additionalMapper.getFavoriteApts(userId);
	}

	@Override
	public int isFavoriteApt(Map<String, Object> map) throws SQLException {
		return additionalMapper.isFavoriteApt(map);
	}

	@Override
	public int addFavoriteApt(Map<String, Object> map) throws SQLException {
		return additionalMapper.addFavoriteApt(map);
	}

	@Override
	public int removeFavoriteApt(Map<String, Object> map) throws SQLException {
		return additionalMapper.removeFavoriteApt(map);
	}
}
