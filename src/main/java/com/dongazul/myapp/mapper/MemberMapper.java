package com.dongazul.myapp.mapper;

import com.dongazul.myapp.domain.MemberVO;

public interface MemberMapper {
	// 회원가입
	public abstract void insert(MemberVO vo) throws Exception;
	// 로그인
	public abstract MemberVO select(MemberVO vo) throws Exception;
	// 이메일 중복체크
	public abstract int emailCheck(MemberVO vo) throws Exception;
	//회원 정보 수정
	public abstract void memberUpdate(MemberVO vo) throws Exception;
} // interface
