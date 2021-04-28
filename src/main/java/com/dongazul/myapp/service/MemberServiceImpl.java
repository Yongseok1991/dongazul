package com.dongazul.myapp.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongazul.myapp.domain.LoginDTO;
import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.mapper.MemberMapper;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@NoArgsConstructor

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper mapper;
	
	
	// 회원가입
	@Override
	public void signUp(MemberVO vo) throws Exception {
		
		log.info("signUp(vo) invoked.");
		
		this.mapper.insert(vo);
	} // signUp
	
	// 로그인
	@Override
	public MemberVO signIn(LoginDTO dto) throws Exception {
		
		log.info("signIn(vo) invoked.");
		
		return this.mapper.select(dto);	
	} // signIn
	
	// 이메일 중복 체크
	@Override
	public int emailCheck(MemberVO vo) throws Exception {
		log.info("emailCheck(vo) invoked.");
		int result = this.mapper.emailCheck(vo);
		return result;
	}
	// 회원정보수정
	@Override
	public void memberUpdate(MemberVO vo) throws Exception{
		this.mapper.memberUpdate(vo);
	}
	
	// 회원탈퇴
	public void memberDelete(MemberVO vo) throws Exception {
		this.mapper.memberDelete(vo);
	}
	
	// 이메일 찾기
	@Override
	public String findId(Integer phonenumber) throws Exception {
		log.debug("findId(vo) invoked.");
		
		return this.mapper.findId(phonenumber);
		
	} // findId
	
	
	// 비밀번호 찾기
	@Override
	public String findPw(String email) throws Exception {
		log.debug("findPw(vo) invoked.");
		
		return this.mapper.findPw(email);
		
	}

	@Override
	public void updateMemberWithRememberMe(String email, String rememberme, Date rememberage) throws Exception {
		log.debug("updateMemberWithRememberMe(email, rememberme, rememberage) invoked.");
		
		log.info("\t+ userid: " + email);
		log.info("\t+ rememberMe: " + rememberme);
		log.info("\t+ rememberAge: " + rememberage);
		
		int modifiedMember = 
			this.
				mapper.
				updateMemberWithRememberMe(email, rememberme, rememberage);
		
		log.info("\t+ modifiedUsers: " + modifiedMember);
	}

	@Override
	public MemberVO selectMemberWithRememberMe(String rememberme) throws Exception {
		log.debug("selectMemberWithRememberMe(rememberme) invoked.");
		
	MemberVO signIn = this.mapper.selectMemberWithRememberMe(rememberme);
		log.info("\t+ user: " + signIn);
		
		return signIn;
	} // findPw
} // end class
