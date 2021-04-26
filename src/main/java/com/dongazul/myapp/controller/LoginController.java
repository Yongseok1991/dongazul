package com.dongazul.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileDTO;
import com.dongazul.myapp.service.MemberService;
import com.dongazul.myapp.service.ProfileService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/login")
public class LoginController {
	
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
	@PostMapping("/signIn")
	public String signInPost(
				MemberVO vo,
				String email,		
				HttpServletRequest req, RedirectAttributes rttrs ) throws Exception {
		log.debug("signInPost(vo, req, rttr) invoked.");
		
		HttpSession session = req.getSession();
		 ProfileDTO select = this.profileservice.getProfile(email);
		 
		MemberVO signIn = this.memberservice.signIn(vo);
		
		if(signIn == null) {
			session.setAttribute("member", null);
			rttrs.addFlashAttribute("msg", "로그인 실패 Email과 Password를 확인해주세요.");
			
			return "redirect:/login/signIn";
			
		} else {
			session.setAttribute("member", signIn);
			
			if(select == null) {
				return "profile/create";
			} else {
				 session.setAttribute("PROFILE", select);
				 
			}
		} 
		rttrs.addFlashAttribute("msg", "로그인이 완료되었습니다.");
		return "redirect:/matching/swipe";
	} // signInPost
	
//	// 로그아웃 화면
//	@GetMapping("/signOut")
//	public String signOutGet() {
//		log.debug("signOutGet() invoked.");
//		
//		session.invalidate();
//		
//		
//	} // signOutGet
	
	// 로그아웃 처리
	@GetMapping("/signOut")
	public String signOutGet(HttpSession session) {
		
		log.debug("signOutGet(session) invoked.");
		
		session.invalidate();
		
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
