package com.ssafy.happyhouse.house.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.additional.model.dto.Favorite;
import com.ssafy.happyhouse.house.model.dto.AptDeal;
import com.ssafy.happyhouse.house.model.dto.AptInfo;
import com.ssafy.happyhouse.house.model.dto.DongInfo;
import com.ssafy.happyhouse.house.model.service.HouseService;
import com.ssafy.happyhouse.member.model.dto.Member;
import com.ssafy.happyhouse.util.ParameterCheck;

@RestController
@RequestMapping("/home")
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private HouseService houseService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<String>> sidoList() throws SQLException {
		return new ResponseEntity<List<String>>(houseService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<String>> gugunList(DongInfo dongInfo) throws SQLException {
		return new ResponseEntity<List<String>>(houseService.getGugun(dongInfo), HttpStatus.OK);
	}
	
	@GetMapping("/dong")
	public ResponseEntity<List<String>> sidoList(DongInfo dongInfo) throws SQLException {
		return new ResponseEntity<List<String>>(houseService.getDong(dongInfo), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getApartList(DongInfo dongInfo) throws SQLException {
		Map<String, Object> map = new HashMap<>();
		String dongCode = houseService.getDongCode(dongInfo);
		map.put("dongCode", dongCode);
		List<AptInfo> list = houseService.getAptInfos(map);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<AptInfo>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/{aptcode}")
	public ResponseEntity<?> getApartInfo(@PathVariable("aptcode") String aptCode) throws SQLException {
		AptInfo info = houseService.getAptInfo(aptCode);
		return new ResponseEntity<AptInfo>(info, HttpStatus.OK);
	}
	
	@GetMapping("/favorite")
	public ResponseEntity<?> favorite(HttpSession session) throws SQLException {
		Member member = (Member) session.getAttribute("userinfo");
		houseService.getFavorites(member.getUserId());
		List<Favorite> list = houseService.getFavorites(member.getUserId());
		
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Favorite>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/favorite")
	public void favorite(@RequestParam("dong") String dongCode, HttpSession session) throws SQLException {
		Map<String, String> map = new HashMap<>();
		Member member = (Member) session.getAttribute("userinfo");
		map.put("dongCode", dongCode);
		map.put("userId", member.getUserId());
		houseService.addFavorite(map);
	}
	
	@DeleteMapping("/favorite/{id}")
	public void delete(@PathVariable ("id") String dongCode, HttpSession session) throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		Member member = (Member) session.getAttribute("userinfo");
		map.put("dongCode", dongCode);
		map.put("userId", member.getUserId());
		houseService.deleteFavorite(map);
	}
	
//	@GetMapping("alist")
//	public ResponseEntity<?> aptList(@RequestParam("dong") String dongCode, int pgno) throws SQLException {
//		Map<String, Object> map = new HashMap<>();
//		map.put("dongCode", dongCode);
//		map.put("pgno", pgno);
//		List<AptInfo> list = houseService.getAptInfos(map);
//		
//		if (list != null && !list.isEmpty()) {
//			Map<String, Object> json = new HashMap<>();
//			json.put("list", list);
//			// 페이지 정보
//			int totalRows = 0, totalPages = 1;
//			totalRows = houseService.totalAptInfoCount(dongCode);
//			totalPages = totalRows % 10 == 0 ? (totalRows / 10) : (totalRows / 10) + 1;
//			if (totalPages == 0) totalPages = 1;
//			if (pgno > totalPages) pgno = 1;
//			int currentBlock = pgno % 5 == 0 ? pgno / 5 : (pgno / 5) + 1;
//			int startPage = (currentBlock - 1) * 5 + 1;
//			int endPage = startPage + 5 - 1;
//			if (endPage > totalPages) endPage = totalPages;
//			json.put("startPage", startPage);
//			json.put("endPage", endPage);
//			json.put("cPage", pgno);
//			json.put("totalPages", totalPages);
//			return new ResponseEntity<Map<String, Object>>(json, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//	}
//
//	@GetMapping("dlist")
//	public ResponseEntity<?> dealList(@RequestParam("dong") String dongCode, int pgno, String year, String month) throws SQLException {
//		Map<String, Object> map = new HashMap<>();
//		map.put("dongCode", dongCode);
//		map.put("pgno", pgno);
//		int dealYear = ParameterCheck.notNumberToZero(year);
//		int dealMonth = ParameterCheck.notNumberToZero(month);
//		map.put("dealYear", dealYear);
//		map.put("dealMonth", dealMonth);
//		List<AptDeal> list = houseService.getAptDeals(map);
//		
//		if (list != null && !list.isEmpty()) {
//			Map<String, Object> json = new HashMap<>();
//			json.put("list", list);
//			// 페이지 정보
//			int totalRows = 0, totalPages = 1;
//			totalRows = houseService.totalAptDealCount(map);
//			totalPages = totalRows % 10 == 0 ? (totalRows / 10) : (totalRows / 10) + 1;
//			if (totalPages == 0) totalPages = 1;
//			if (pgno > totalPages) pgno = 1;
//			int currentBlock = pgno % 5 == 0 ? pgno / 5 : (pgno / 5) + 1;
//			int startPage = (currentBlock - 1) * 5 + 1;
//			int endPage = startPage + 5 - 1;
//			if (endPage > totalPages) endPage = totalPages;
//			json.put("startPage", startPage);
//			json.put("endPage", endPage);
//			json.put("cPage", pgno);
//			json.put("totalPages", totalPages);
//			return new ResponseEntity<Map<String, Object>>(json, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//	}
//
//	@GetMapping("adlist")
//	public ResponseEntity<?> apartDealList(@RequestParam("aptcode") String aptCode, int pgno, String year, String month) throws SQLException {
//		Map<String, Object> map = new HashMap<>();
//		map.put("aptCode", aptCode);
//		map.put("pgno", pgno);
//		int dealYear = ParameterCheck.notNumberToZero(year);
//		int dealMonth = ParameterCheck.notNumberToZero(month);
//		map.put("dealYear", dealYear);
//		map.put("dealMonth", dealMonth);
//		List<AptDeal> list = houseService.getAptDeals(map);
//		
//		if (list != null && !list.isEmpty()) {
//			Map<String, Object> json = new HashMap<>();
//			json.put("list", list);
//			// 페이지 정보
//			int totalRows = 0, totalPages = 1;
//			totalRows = houseService.totalAptDealCount(map);
//			totalPages = totalRows % 10 == 0 ? (totalRows / 10) : (totalRows / 10) + 1;
//			if (totalPages == 0) totalPages = 1;
//			if (pgno > totalPages) pgno = 1;
//			int currentBlock = pgno % 5 == 0 ? pgno / 5 : (pgno / 5) + 1;
//			int startPage = (currentBlock - 1) * 5 + 1;
//			int endPage = startPage + 5 - 1;
//			if (endPage > totalPages) endPage = totalPages;
//			json.put("startPage", startPage);
//			json.put("endPage", endPage);
//			json.put("cPage", pgno);
//			json.put("totalPages", totalPages);
//			return new ResponseEntity<Map<String, Object>>(json, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//	}

}
