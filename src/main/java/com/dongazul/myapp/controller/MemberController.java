package com.dongazul.myapp.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		log.debug("signUpGet() invoked.");
	} // signUpGet
	
	// 회원가입 처리
	@PostMapping("/signUp")
	public String signUpPost(MemberVO vo, RedirectAttributes rttrs) throws Exception {
		
		log.debug("signUpPost(vo) invoked.");
		
		int result = service.emailCheck(vo);
		
		try {
			if(result==1) {
				
				rttrs.addFlashAttribute("msg","실패! 다시 확인해주세요");
				return "/member/signUp";
				
			} else if(result==0) {
				
				rttrs.addFlashAttribute("msg","가입이 완료되었습니다.");
				service.signUp(vo);
			} // if-else
			
		} catch(Exception e) {
			
			throw new RuntimeException();
		} // try-catch
		
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
	public String infoPost(MemberVO vo, HttpSession session) throws Exception {
		
		log.debug("infoPost() invoked.");
		
		service.memberUpdate(vo);
		
		session.invalidate();
		
		return "redirect:/login/signIn";
	} // infoPost
	
	// 회원탈퇴화면 보여주기
	@GetMapping("/dropOut")
	public void dropOutGet() {
		
		log.debug("dropOutGet() invoked.");
	} // dropOutGet
	
	// 회원탈퇴 처리
	@PostMapping("/dropOut")
	public String dropOutPost(
			MemberVO vo,
			HttpSession session,
			RedirectAttributes rttrs
			) throws Exception {
		
		log.debug("dropOutPost(vo, session, rttrs) invoked.");
		

		MemberVO member = (MemberVO) session.getAttribute("member");
		
		String sessionPass = member.getPasswd();
	
		String voPass = vo.getPasswd();
		
		if(!(sessionPass.equals(voPass))) {
			
			rttrs.addFlashAttribute("msg", false);
			
			return "redirect:/member/dropout";
		} // if
		
		service.memberDelete(vo);
		
		session.invalidate();
		
		return "redirect:/login/signIn";
} // dropOutPost
   
   // 이메일 중복 체크
   @ResponseBody
   @PostMapping("/emailCheck")
   public int emailCheck(MemberVO vo) throws Exception {
	   
	   log.debug("emailCheck(vo) invoked.");
	 
	   return service.emailCheck(vo);
   } // emailCheck

} // end class
