package com.ssafy.happyhouse.member.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.member.model.dto.Member;
import com.ssafy.happyhouse.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	private MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	@Override
	public int idCheck(String userId) throws Exception {
		return memberMapper.idCheck(userId);
	}

	@Override
	public void joinMember(Member member) throws Exception {
		memberMapper.joinMember(member);
	}

	@Override
	public Member loginMember(Member member) throws Exception{
		return memberMapper.loginMember(member);
	}

	@Override
	public Member getMember(String userId) throws SQLException {
		return memberMapper.getMember(userId);
	}

	@Override
	public void modifyMember(Member member) throws Exception {
		memberMapper.modifyMember(member);
	}

	@Override
	public void deleteMember(Member member) throws Exception {
		memberMapper.deleteMember(member);
	}

}
