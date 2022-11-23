package com.ssafy.happyhouse.additional.service;

import java.sql.SQLException;
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
}
