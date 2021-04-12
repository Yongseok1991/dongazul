package com.dongazul.myapp.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.SignInVO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Repository
public class MemberDAOImpi implements MemberDAO {

	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	
	//회원가입
	@Override
	public void signUp(MemberVO vo) throws Exception {
		log.info("signUp(vo) invoked.");
		
		Objects.requireNonNull(sqlSessionFactory);
		
		log.info("\t+ sqlSessionFactory" + this.sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try(sqlSession) {
		
		sqlSession.insert("memberMapper.signUp", vo);
		
		}
		
	} // register
	// 로그인
	@Override
	public SignInVO signIn(SignInVO vo) throws Exception {
		log.info("signIn(vo) invoked.");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try(sqlSession) {
		return sqlSession.selectOne("memberMapper.signIn", vo);
		}
	}
	// 이메일 중복 체크
	@Override
	public int emailCheck(MemberVO vo) throws Exception {
		
		log.info("emailCheck(vo) invoked.");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try(sqlSession) {
		int result = sqlSession.selectOne("memberMapper.emailCheck", vo);
		return result;
		}
	}

} // end class
