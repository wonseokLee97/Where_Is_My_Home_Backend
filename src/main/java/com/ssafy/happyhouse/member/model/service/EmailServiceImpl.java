package com.ssafy.happyhouse.member.model.service;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
 
@Service
public class EmailServiceImpl implements EmailService{
 
    @Autowired
    JavaMailSender emailSender;

 
    private MimeMessage createMessage(String pwd, String to)throws Exception{
        System.out.println("보내는 대상 : "+ to);
        MimeMessage  message = emailSender.createMimeMessage();
 
        message.addRecipients(RecipientType.TO, to);//보내는 대상
        message.setSubject("비밀번호 찾기 안내 메일");//제목
 
        String msgg="";
        msgg+= "<div style='margin:40px;'>";
        msgg+= "<h1> WhereIsMyHome 비밀번호 찾기 안내 메일입니다. </h1>";
        msgg+= "<br>";
        msgg+= "<br>";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3>회원님의 비밀번호 입니다.</h3>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "Password : <strong>";
        msgg+= pwd+"</strong><div><br/> ";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("bulnabang99@gmail.com","SSAFY"));//보내는 사람
        
        System.out.println(message);
        return message;
    }
 
   
    @Override
    public String sendSimpleMessage(String pwd, String to)throws Exception {
        // TODO Auto-generated method stub
        MimeMessage message = createMessage(pwd, to);
        try{//예외처리
            emailSender.send(message);
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
        return pwd;
    }
}
