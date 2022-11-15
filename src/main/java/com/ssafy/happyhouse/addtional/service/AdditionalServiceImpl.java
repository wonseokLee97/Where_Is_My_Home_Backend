package com.ssafy.happyhouse.addtional.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.additional.model.dto.Hospital;
import com.ssafy.happyhouse.additional.model.dto.Pollution;
import com.ssafy.happyhouse.additional.model.dto.Store;
import com.ssafy.happyhouse.additional.model.mapper.AdditionalMapper;

@Service
public class AdditionalServiceImpl implements AdditionalService {

	private AdditionalMapper addtionalMapper;
	
	@Autowired
	private AdditionalServiceImpl(AdditionalMapper addtionalMapper) {
		this.addtionalMapper = addtionalMapper;
	}
	
	@Override
	public List<Store> getSelectedStores(String dongCode) throws SQLException {
		return addtionalMapper.getSelectedStores(dongCode);
	}

	@Override
	public List<Store> getFavoriteStores(String userId) throws SQLException {
		return addtionalMapper.getFavoriteStores(userId);
	}

	@Override
	public List<Pollution> getSelectedPolls(String sidoName, String gugunName, String dongName) throws SQLException {
		return addtionalMapper.getSelectedPolls(sidoName, gugunName, dongName);
	}

	@Override
	public List<Pollution> getFavoritePolls(String userId) throws SQLException {
		return addtionalMapper.getFavoritePolls(userId);
	}

	@Override
	public List<Hospital> getSelectedHospitals(String sidoName, String gugunName) throws SQLException {
		return addtionalMapper.getSelectedHospitals(sidoName, gugunName);
	}

	@Override
	public List<Hospital> getSelectedCoronaTests(String sidoName, String gugunName) throws SQLException {
		return addtionalMapper.getSelectedCoronaTests(sidoName, gugunName);
	}
}
