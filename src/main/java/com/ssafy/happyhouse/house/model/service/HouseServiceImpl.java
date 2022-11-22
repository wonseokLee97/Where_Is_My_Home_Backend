package com.ssafy.happyhouse.house.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.additional.model.dto.Favorite;
import com.ssafy.happyhouse.house.model.dto.AptDeal;
import com.ssafy.happyhouse.house.model.dto.AptInfo;
import com.ssafy.happyhouse.house.model.dto.DongInfo;
import com.ssafy.happyhouse.house.model.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService {

	private HouseMapper houseMapper;
	
	@Autowired
	private HouseServiceImpl(HouseMapper houseMapper) {
		this.houseMapper = houseMapper;
	}
	
	@Override
	public String getDongCode(DongInfo dongInfo) throws SQLException {
		return houseMapper.getDongCode(dongInfo);
	}

	@Override
	public AptInfo getAptInfo(String aptCode) throws SQLException {
		return houseMapper.getAptInfo(aptCode);
	}
	
	@Override
	public List<AptInfo> getAptInfos(Map<String, Object> map) throws SQLException {
		return houseMapper.getAptInfos(map);
	}

	@Override
	public List<AptInfo> getAptInfos(DongInfo dongInfo) throws SQLException {
		return houseMapper.getAptInfosByDongInfo(dongInfo);
	}
	
	@Override
	public List<AptInfo> getAptInfosByLngLat(Map<String, Object> map) throws SQLException {
		return houseMapper.getAptInfosByLngLat(map);
	}
	
	@Override
	public List<AptDeal> getAptDeals(Map<String, Object> map) throws SQLException {
		return houseMapper.getAptDeals(map);
	}

	@Override
	public int totalAptInfoCount(String dongCode) throws SQLException {
		return houseMapper.totalAptInfoCount(dongCode);
	}
	
	@Override
	public int totalAptDealCount(Map<String, Object> map) throws SQLException {
		return houseMapper.totalAptDealCount(map);
	}
	
	@Override
	public List<Favorite>  getFavorites(String userId) throws SQLException {
		return houseMapper.getFavorites(userId);
	}

	@Override
	public boolean addFavorite(Map<String, String> map) throws SQLException {
		return houseMapper.addFavorite(map);
	}

	@Override
	public boolean deleteFavorite(Map<String, String> map) throws SQLException {
		return houseMapper.deleteFavorite(map);
	}

	@Override
	public List<AptDeal> getFavoriteLatest(String userId) throws SQLException {
		return houseMapper.getFavoriteLatest(userId);
	}

	@Override
	public List<String> getSido() throws SQLException {
		return houseMapper.getSido();
	}

	@Override
	public List<String> getGugun(DongInfo dongInfo) throws SQLException {
		return houseMapper.getGugun(dongInfo);
	}

	@Override
	public List<String> getDong(DongInfo dongInfo) throws SQLException {
		return houseMapper.getDong(dongInfo);
	}

}
