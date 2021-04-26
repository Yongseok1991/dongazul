package com.dongazul.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongazul.myapp.domain.ProfileDTO;
import com.dongazul.myapp.mapper.ProfileMapper;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileMapper mapper;

	@Transactional
	@Override
	public void craeteProfile(ProfileDTO dto) throws Exception {
		
		log.info("craeteProfile(dto) invoked.");
		
		this.mapper.insertProfile(dto);
		this.mapper.insertInterests(dto);
	
	} // createProfile

	@Override
	public ProfileDTO getProfile(String email) throws Exception {
		return this.mapper.selectProfile(email);
	} // getProfile


} // end class
