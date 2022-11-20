package com.ssafy.happyhouse.member.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.member.model.dto.Member;
import com.ssafy.happyhouse.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	private MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	@Autowired
	private JavaMailSender mailSender;
	private static final String FROM_ADDRESS = "bulnabang99@gmail.com";
	
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
	public void deleteMember(String userId) throws Exception {
		memberMapper.deleteMember(userId);
	}

	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", refreshToken);
		memberMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return memberMapper.getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		memberMapper.deleteRefreshToken(map);
	}

	@Override
	public Member getEmail(String userName) throws Exception {
		return memberMapper.getEmail(userName);
	}

//	@Override
//	public void sendMail(String userPwd, String email) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(email);
//		message.setFrom(FROM_ADDRESS);
//		message.setSubject("WhereIsMyHome 비밀번호 찾기 안내 메일입니다.");
//		message.setText("귀하의 비밀번호는 [" + userPwd +"] 입니다.");
//		System.out.println(message);
//		mailSender.send(message);
//		System.out.println("!!");
//	}
}
