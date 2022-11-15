package com.ssafy.happyhouse.member.model.service;

import com.ssafy.happyhouse.member.model.dto.Member;

public interface MemberService {

	int idCheck(String userId) throws Exception;
	void joinMember(Member member) throws Exception;
	Member loginMember(Member member)throws Exception;
	Member getMember(String userId) throws Exception;
	void modifyMember(Member member) throws Exception;
	void deleteMember(Member member) throws Exception;
	
}
