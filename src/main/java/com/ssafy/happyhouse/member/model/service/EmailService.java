package com.ssafy.happyhouse.member.model.service;

public interface EmailService {
    String sendSimpleMessage(String pwd, String to)throws Exception;
}
