package com.ssafy.happyhouse.exception.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//컨트롤러 전역에서 발생하는 예외를 처리하는 부기가능을 가진 클래스(어드바이스)
@ControllerAdvice
public class ExceptionController {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		logger.error("예외 발생" , e.getCause());
		
		
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
