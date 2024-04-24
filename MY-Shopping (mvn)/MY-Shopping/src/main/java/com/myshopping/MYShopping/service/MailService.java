//package com.myshopping.MYShopping.service;
//
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMailMessage;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailService {
//@Autowired
//JavaMailSender javaMailSender;
//
//public void sendMail(String message, String buyerEmail,String subjectLine){
//    MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//    MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
//
//    try{
//        mimeMessageHelper.setTo(buyerEmail);
//        mimeMessageHelper.setSubject(subjectLine);
//        mimeMessageHelper.setText(message);
//        javaMailSender.send(mimeMessage);
//    }catch(Exception e){
//
//    }
//}
//
//
//}
