package com.ssafy.happyhouse.member.model.service;

import com.ssafy.happyhouse.member.model.dto.Member;

public interface MemberService {

	int idCheck(String userId) throws Exception;
	void joinMember(Member member) throws Exception;
	Member loginMember(Member member)throws Exception;
	Member getMember(String userId) throws Exception;
	void modifyMember(Member member) throws Exception;
	void deleteMember(String userId) throws Exception;
	public void saveRefreshToken(String userid, String refreshToken) throws Exception;
	public Object getRefreshToken(String userid) throws Exception;
	public void deleRefreshToken(String userid) throws Exception;
	Member getEmail(String userName) throws Exception;
}
