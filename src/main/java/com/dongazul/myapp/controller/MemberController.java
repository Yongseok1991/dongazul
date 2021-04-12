 package com.dongazul.myapp.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.service.MemberService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	// 회원가입 화면
	@GetMapping("/signUp")
	public void signUpGet() throws Exception {
		
		log.info("signUpGet() invoked.");
	} // signUpGet
	
	// 회원가입 처리
	@PostMapping("/signUp")
	public String signUpPost(MemberVO vo) throws Exception {
		
		log.info("signUpPost(vo) invoked.");
		
		int result = service.emailCheck(vo);
		
		try {
			if(result==1) {
				
				return "/member/signUp";
				
			} else if(result==0) {
				
				service.signUp(vo);
			}
		} catch(Exception e) {
			throw new RuntimeException();
		}
		
		return "redirect:/login/signIn";
		
	} // signUpPost
		//이메일 인증 전송
		@PostMapping("/authSend")
		public void authSendPost () {
			
			log.debug("authSendPost() invoked.");
			
		} // authSendPost
		
		// 이메일 인증 응답
		@PostMapping("/authRecv")
		public void authRecvPost() {
			
			log.debug("authRecvPost() invoked.");

		} // authRecvPost
		
		// 비밀번호 변경 화면
		@GetMapping("/changePw")
		public void infoGet() {
			
			log.debug("infoGet() invoked.");
		
		} // infoGet
		
		// 비밀번호 변경 처리
		@PostMapping("/changePw")
		public void infoPost(String passwd) {
			
			log.debug("infoPost() invoked.");
			
			Objects.requireNonNull(passwd);
			
			log.info("\t+ passwd :" + passwd);
		
		} // infoPost
		
		
		@GetMapping("/dropOut")
		public void dropOutGet() {
			
			log.debug("dropOutGet() invoked.");
		
		} // dropOutGet
		
		@PostMapping("/dropOut")
		public void dropOutPost(String email) {
			
			log.debug("dropOutPost() invoked.");
			
			Objects.requireNonNull(email);
			
			log.info("\t+ email :" + email);
		
 	} // dropOutPost
	   
	   // 이메일 중복 체크
	   @ResponseBody
	   @PostMapping("/emailCheck")
       public int emailCheck(MemberVO vo) throws Exception {
		   
	   int result = service.emailCheck(vo);
	   
	   return result;
	} // emailCheck

} // end class
