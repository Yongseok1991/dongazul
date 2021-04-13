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
import com.dongazul.myapp.service.MemberService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	MemberService service;

	
	
	// 로그인 화면
	@GetMapping("/signIn")
	public void signInGet() {
		
		log.debug("signInGet() invoked.");
	} // signInGet
	
	// 로그인 처리
	@PostMapping("/signIn")
	public String signInPost(MemberVO vo,
				HttpServletRequest req, RedirectAttributes rttr ) throws Exception {
		log.debug("signInPost(vo, req, rttr) invoked.");
		
		HttpSession session = req.getSession();
		
		MemberVO signIn = service.signIn(vo);
		
		if(signIn == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/login/signIn";
			
		} else {
			session.setAttribute("member", signIn);
			
		}
	
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
   @PostMapping("/findId")
   public void findIdPost(Integer phoneNumber) {
      log.debug("findIdPost(phoneNumber) invoked.");
   } // findIdPost
   
   // 비밀번호 찾기 화면
   @GetMapping("/findPw")
   public void findPwGet() {
      log.debug("findPwGet() invoked.");
   } // findPwGet
   
   // 비밀번호 찾기 처리
   @PostMapping("/findPw")
   public void findPwPost(String email) {
      log.debug("findPwPost(email) invoked.");
      
   } // findPwPost

} // end class
