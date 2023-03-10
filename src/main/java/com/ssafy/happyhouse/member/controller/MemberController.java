package com.ssafy.happyhouse.member.controller;

import java.util.HashMap;
import java.util.Map;

//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.member.model.dto.MailInfo;
import com.ssafy.happyhouse.member.model.dto.Member;
import com.ssafy.happyhouse.member.model.service.EmailService;
import com.ssafy.happyhouse.member.model.service.JwtServiceImpl;
import com.ssafy.happyhouse.member.model.service.MemberService;

@RestController
@RequestMapping("/user")
public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/idcheck")
	public int idCheck(String userId) throws Exception {
		System.out.println(userId);
		int count = memberService.idCheck(userId);
		return count;
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody Member member) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			Member loginUser = memberService.loginMember(member);
			if (loginUser != null) {
				String accessToken = jwtService.createAccessToken("userid", loginUser.getUserId());// key, data
				String refreshToken = jwtService.createRefreshToken("userid", loginUser.getUserId());// key, data
				memberService.saveRefreshToken(member.getUserId(), refreshToken);
				logger.debug("????????? accessToken ?????? : {}", accessToken);
				logger.debug("????????? refreshToken ?????? : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("????????? ?????? : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@GetMapping("/logout/{userid}")
	public ResponseEntity<?> removeToken(@PathVariable("userid") String userid) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			memberService.deleRefreshToken(userid);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("???????????? ?????? : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@PostMapping
	public ResponseEntity<String> join(@RequestBody Member member) throws Exception {
		memberService.joinMember(member);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> modify(@RequestBody Member member) throws Exception {
		memberService.modifyMember(member);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<String> delete(@PathVariable("userid") String userid) throws Exception {
		memberService.deleteMember(userid);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@PostMapping("/email")
	public ResponseEntity<Map<String, Object>> getEmail(@RequestBody MailInfo info) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		
		try {
			Member member = memberService.getEmail(info.getUserName());
			if (member != null) {
				String email = member.getEmailId() + "@" + member.getEmailDomain();
				
				if (email.equals(info.getUserEmail())) {
					resultMap.put("userEmail", member);
					resultMap.put("message", SUCCESS);
					String confirm = emailService.sendSimpleMessage(member.getUserPwd(), email);
				} else {
					return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.NO_CONTENT);
				}
			} else {
				return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			logger.error("???????????? ?????? : {}",e);
			resultMap.put("message", e.getMessage());
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") String userid,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("?????? ????????? ??????!!!");
			try {
				Member member = memberService.getMember(userid);
				resultMap.put("userInfo", member);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("???????????? ?????? : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("?????? ????????? ??????!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody Member member, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, member);
		if (jwtService.checkToken(token)) {
			if (token.equals(memberService.getRefreshToken(member.getUserId()))) {
				String accessToken = jwtService.createAccessToken("userid", member.getUserId());
				logger.debug("token : {}", accessToken);
				logger.debug("??????????????? ??????????????? ?????????!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("????????????????????? ?????????!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
