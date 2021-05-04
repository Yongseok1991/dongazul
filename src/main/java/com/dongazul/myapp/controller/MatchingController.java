package com.dongazul.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dongazul.myapp.service.ProfileService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/matching")
public class MatchingController {

	@Autowired
	ProfileService profileService;
	
	// 메인화면 보여주기
	@GetMapping("/swipe")
	public void swipeGet() throws Exception {
		
		log.debug("swipeGet() invoked.");
	} // swipeGet
	
	@GetMapping("/profile")
	public void profileGet() {
		
		log.debug("profileGet() invoked.");
	} // profileGet
	
	@PostMapping("/like")
	public void likePost() {
		
		log.debug("likePost() invoked.");
	} // likePost

} // end class
