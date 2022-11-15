package com.ssafy.happyhouse.member.model.mapper;

import java.sql.SQLException;

import com.ssafy.happyhouse.member.model.dto.Member;

public interface MemberMapper {
	
	int idCheck(String userId) throws SQLException;
	void joinMember(Member member) throws SQLException;
	Member loginMember(Member member) throws SQLException;
	Member getMember(String userId) throws SQLException;
	void modifyMember(Member member) throws SQLException;
	void deleteMember(Member member) throws SQLException;
	
}
