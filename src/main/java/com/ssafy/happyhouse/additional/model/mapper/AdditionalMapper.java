package com.ssafy.happyhouse.additional.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.additional.model.dto.Hospital;
import com.ssafy.happyhouse.additional.model.dto.Pollution;
import com.ssafy.happyhouse.additional.model.dto.Store;

public interface AdditionalMapper {

	List<Store> getSelectedStores(String dongCode) throws SQLException;
	List<Store> getFavoriteStores(String userId) throws SQLException;

	List<Pollution> getSelectedPolls(String sidoName, String gugunName, String dongName) throws SQLException;
	List<Pollution> getFavoritePolls(String userId) throws SQLException;

	List<Hospital> getSelectedHospitals(String sidoName, String gugunName) throws SQLException;
	List<Hospital> getSelectedCoronaTests(String sidoName, String gugunName) throws SQLException;
	
}
