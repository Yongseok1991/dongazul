package com.dongazul.myapp.mapper;

import com.dongazul.myapp.domain.ProfileDTO;

public interface ProfileMapper {

	
	// 프로필 생성
	public abstract boolean insertProfile(ProfileDTO dto) throws Exception;
	
	
	public abstract boolean insertInterests(ProfileDTO dto) throws Exception;
	
	public abstract ProfileDTO selectProfile(String email) throws Exception;
	
	// 프로필 수정
	public abstract int updateProfile(ProfileDTO dto) throws Exception;
	
	public abstract int updateInterest(ProfileDTO dto) throws Exception;
	
} // end class
