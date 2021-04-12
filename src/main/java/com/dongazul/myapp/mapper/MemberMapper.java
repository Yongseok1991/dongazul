package com.dongazul.myapp.mapper;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.SignInVO;

public interface MemberMapper {
	// 회원가입
	public abstract void insert(MemberVO vo) throws Exception;
	// 로그인
	public abstract SignInVO select(SignInVO vo) throws Exception;
	// 이메일 중복체크
	public abstract int select(MemberVO vo) throws Exception;
} // interface
