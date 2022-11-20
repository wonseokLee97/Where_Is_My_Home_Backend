package com.ssafy.happyhouse.member.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.happyhouse.member.model.dto.Member;

public interface MemberMapper {
	
	int idCheck(String userId) throws SQLException;
	void joinMember(Member member) throws SQLException;
	Member loginMember(Member member) throws SQLException;
	Member getMember(String userId) throws SQLException;
	void modifyMember(Member member) throws SQLException;
	void deleteMember(String userId) throws SQLException;
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String userid) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
	Member getEmail(String userName) throws SQLException;
}
