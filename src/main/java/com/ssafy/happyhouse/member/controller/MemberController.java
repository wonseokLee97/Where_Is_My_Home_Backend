package com.ssafy.happyhouse.member.controller;

import java.util.Map;

//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happyhouse.member.model.dto.Member;
import com.ssafy.happyhouse.member.model.service.MemberService;

@RestController
@RequestMapping("/user")
public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private MemberService memberService;

	@GetMapping("/idcheck")
	public int idCheck(@RequestParam("userId") String userId) throws Exception {
		System.out.println(userId);
		int count = memberService.idCheck(userId);
		return count;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Member member, RedirectAttributes redirectAttributes,
			HttpSession session, HttpServletResponse response) throws Exception {
		logger.info("post: login");
		System.out.println(member);
		Member memberDto = memberService.loginMember(member);
		if (memberDto != null) {
			session.setAttribute("userinfo", memberDto);

//			Cookie cookie = new Cookie("ssafy_id", map.get("userid"));
//			cookie.setPath("/board");
//			if("ok".equals(map.get("saveid"))) {
//				cookie.setMaxAge(60*60*24*365*40);
//			} else {
//				cookie.setMaxAge(0);
//			}
//			response.addCookie(cookie);
			return new ResponseEntity<String>(member.getUserId(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("logout")
	public ResponseEntity<String> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestBody Member member) throws Exception {
		memberService.joinMember(member);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<String> userModify(@RequestBody Member member) throws Exception {
		memberService.modifyMember(member);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("/user")
	public ResponseEntity<String> userDelete(HttpSession session, Model model) throws Exception {
		Member member = (Member) session.getAttribute("userinfo");
		if (member != null) {
			memberService.deleteMember(member);
		}
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@PostMapping("/findpw")
	private ResponseEntity<String> findUser(@RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes, Model model) throws Exception {
		String userId = map.get("userId");
		String userName = map.get("userName");
		String emailId = map.get("emailid");
		String emailDomain = map.get("emaildomain");
		Member memberDto = memberService.getMember(userId);

		if (userName.equals(memberDto.getUserName()) && emailId.equals(memberDto.getEmailId())
				&& emailDomain.equals(memberDto.getEmailDomain())) {
			return new ResponseEntity<String>(memberDto.getUserPwd(), HttpStatus.OK);
		}

		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
