package com.dongazul.myapp.service;

import com.dongazul.myapp.domain.MemberVO;

public interface MemberService {
	//회원가입
	public void signUp(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO signIn(MemberVO vo) throws Exception;
	
	//이메일 중복 체크
	public int emailCheck(MemberVO vo) throws Exception;
	// 회원 정보 수정
	public void memberUpdate(MemberVO vo) throws Exception;
	
 
} // end class
