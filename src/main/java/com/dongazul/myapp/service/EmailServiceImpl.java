//package com.dongazul.myapp.service;
//
//import java.io.File;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import lombok.Setter;
//@Setter
//@Service
//public class EmailServiceImpl implements EmailService {
//	
//	
//    private JavaMailSender javaMailSender;
// 
//    @Override
//    public boolean send(String subject, String text, String from, String to, String filePath) {
//        // javax.mail.internet.MimeMessage
//        MimeMessage message = javaMailSender.createMimeMessage();
// 
//        try {
//            // org.springframework.mail.javamail.MimeMessageHelper
//            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//            helper.setSubject(subject);
//            helper.setText(text, true);
//            helper.setFrom(from);
//            helper.setTo(to);
// 
//            // 첨부 파일 처리
//            if (filePath != null) {
//                File file = new File(filePath);
//                if (file.exists()) {
//                    helper.addAttachment(file.getName(), new File(filePath));
//                }
//            }
// 
//            javaMailSender.send(message);
//            return true;
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//} // end class
//
