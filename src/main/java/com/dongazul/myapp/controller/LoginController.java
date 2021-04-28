package com.dongazul.myapp.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.dongazul.myapp.domain.LoginDTO;
import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.interceptor.AuthInterceptor;
import com.dongazul.myapp.service.MemberService;
import com.dongazul.myapp.service.ProfileService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	public static final String loginKey = "member";	
	public static final String rememberMeKey = 
					AuthInterceptor.rememberMeKey;
	
	@Autowired
	MemberService memberservice;

	@Autowired
	ProfileService profileservice;
	
	
	// 로그인 화면
	@GetMapping("/signIn")
	public void signInGet() {
		
		log.debug("signInGet() invoked.");
	} // signInGet
	
	// 로그인 처리
	@PostMapping("/signInPost")
	public String signInPost(
				LoginDTO dto,
				String email,
				HttpSession session, Model model, RedirectAttributes rttrs) throws Exception {
		log.debug("signInPost(dto, session, model) invoked.");
		
		
		MemberVO signIn = this.memberservice.signIn(dto);
		
		if(signIn != null) {
			
			model.addAttribute(loginKey, signIn);
			
			if(dto.isRememberme()) {
				   String emails = dto.getEmail();
				   String rememberme = session.getId();
				   
				   int timeAmount = 1000 * 60 * 24 * 7;
				   Date rememberage =
						   new Date(System.currentTimeMillis() + timeAmount);
				   
				   this.memberservice.
				   updateMemberWithRememberMe(emails, rememberme, rememberage);
				   
				   log.info("\t+ 자동로그인 정보 업데이트 완료.");
				 
				
				   
			} // if
			
		} // if
		
		return null;
	} // signInPost
	

	
	// 로그아웃 처리
	@GetMapping("/signOut")
	public String signOutGet(
			HttpServletRequest req,
			HttpServletResponse res,
			HttpSession session) throws Exception {
		
		log.debug("signOutGet(session) invoked.");
		MemberVO signIn = (MemberVO) session.getAttribute(loginKey);
		
		session.invalidate();
		
		Cookie rememberMeCookie = 
				WebUtils.getCookie(req, rememberMeKey);
			
		if(rememberMeCookie != null) {
			rememberMeCookie.setPath("/");
			rememberMeCookie.setMaxAge(0);	/*** 쿠키파괴를 위한 가장 중요한 설정 ***/
				
			res.addCookie(rememberMeCookie);	// 브라우저로 이 쿠키가 전송 => 파괴
		} // if
		
		if(signIn != null) {
			this.memberservice.
			updateMemberWithRememberMe(signIn.getEmail(), null, null);			
		} // if
		return "redirect:/login/signIn";
	} // signOutPost
	
	// 아이디 찾기 화면
   @GetMapping("/findId")
   public void findIdGet() {
      log.debug("findIdGet() invoked.");      
   } // findIdGet
   
   // 아아디 찾기 처리
   @PostMapping("/findIdResult")
   public String findIdPost(MemberVO vo, Integer phonenumber, HttpSession session) throws Exception {
      log.debug("findIdPost(phoneNumber) invoked.");
      
      String result = memberservice.findId(phonenumber);
      
      if(result != null) {
    	  session.setAttribute("FIND", result);
    	  return "/login/findIdResult";
      } else {
    	  return "redirect:/login/findId";
      }
      
   } // findIdPost
   
   // 비밀번호 찾기 화면
   @GetMapping("/findPw")
   public void findPwGet() {
      log.debug("findPwGet() invoked.");
      
      
   } // findPwGet
   
   // 비밀번호 찾기 처리
   @PostMapping("/findPwResult")
   public String findPwPost(String email, HttpSession session) throws Exception {
      log.debug("findPwPost(email) invoked.");
      
      String pw = memberservice.findPw(email);
      
      
      
      if(pw != null) {
    	  session.setAttribute("FINDPW", pw);
    	  return "/login/findPwResult";
      } else {
    	  return "redirect:/login/findPw";
      }
      
   } // findPwPost

} // end class
