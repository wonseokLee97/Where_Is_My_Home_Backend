package com.ssafy.happyhouse.member.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happyhouse.member.model.dto.Member;
import com.ssafy.happyhouse.member.model.mapper.MemberMapper;
import com.ssafy.happyhouse.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController extends HttpServlet {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/idcheck")
	@ResponseBody
	public int idCheck(@RequestParam("userId") String userId) throws Exception {
		System.out.println(userId);
		int count = memberService.idCheck(userId);
		return count;
	}
	
	@GetMapping("/login")
	public String login() {
		logger.info("get: login");
		return "/user/login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Member member, RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) throws Exception {
		logger.info("post: login");
		System.out.println(member);
		Member memberDto = memberService.loginMember(member);
		if(memberDto != null) {
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
	public String logout(HttpSession session) {
			session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}

	
	@PostMapping("/join")
	public String join(@RequestBody Member member) throws Exception {
		System.out.println("member: " + member);
		memberService.joinMember(member);
		return "/user/login";
	}

	@GetMapping("/user")
	public String userDetail() {
		return "/user/userDetail";
	}

	
	@PutMapping("/user")
	public String userModify(@RequestBody Member member, Model model) throws Exception {
		logger.info("Put: modify");
		logger.debug("member info : {}", member);
		
		memberService.modifyMember(member);
		model.addAttribute("msg2", "변경처리 되었습니다.");
		return "redirect:/";	
	}
	
	
	@DeleteMapping("/user")
	public String userDelete(HttpSession session, Model model) throws Exception {
		Member member = (Member)session.getAttribute("userinfo");
		if(member != null) {
			memberService.deleteMember(member);
			model.addAttribute("msg2", "탈퇴처리 되었습니다.");
			return "redirect:/user/logout";
		}
		return "redirect:/";
	}

	
	
	@GetMapping("/findpw")
	public String findpw() {
		return "/user/findpw";
	}
	

	@PostMapping("/findpw")
	private String findUser(@RequestParam Map<String, String> map, RedirectAttributes redirectAttributes, Model model) throws Exception {
		logger.debug("map info : {}", map);
		logger.debug("get info userId : {}", map.get("userId"));
		String userId = map.get("userId");
		String userName = map.get("userName");
		String emailId = map.get("emailid");
		String emailDomain = map.get("emaildomain");

		
		Member memberDto = memberService.getMember(map.get("userId"));
		logger.info("memberDto : {}",  memberDto);

		if(userName.equals(memberDto.getUserName()) &&
				emailId.equals(memberDto.getEmailId()) &&
				emailDomain.equals(memberDto.getEmailDomain()) ) {
			System.out.println("!!");
			redirectAttributes.addFlashAttribute("msg2", "회원 비밀번호는 "+ memberDto.getUserPwd() + "입니다. 다시 로그인해주시기 바랍니다.");
			return "redirect:/";
		}
		
		redirectAttributes.addFlashAttribute("msg2", "존재하지 않는 회원입니다.");
		return "redirect:/";
	}

}
