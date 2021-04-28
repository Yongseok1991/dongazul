package com.dongazul.myapp.mapper;

import com.dongazul.myapp.domain.ProfileDTO;

public interface ProfileMapper {

	
	// 프로필 생성
	public abstract boolean insertProfile(ProfileDTO dto) throws Exception;
	
	public abstract boolean insertInterests(ProfileDTO dto) throws Exception;
	
	public abstract ProfileDTO selectProfile(String email) throws Exception;
} // end class