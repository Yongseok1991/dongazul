package com.dongazul.myapp.service;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.SignInVO;

public interface MemberService {
	//회원가입
	public void signUp(MemberVO vo) throws Exception;
	
	// 로그인
	public SignInVO signIn(SignInVO vo) throws Exception;
	
	//이메일 중복 체크
	public int emailCheck(MemberVO vo) throws Exception;
	
	
 
} // end class
