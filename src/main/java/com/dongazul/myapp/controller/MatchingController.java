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


@RequestMapping("/matching")

@Controller
public class MatchingController {

	@Autowired
	ProfileService profileService;
	
	@GetMapping("/swipe")
	public void swipeGet() throws Exception {
		log.debug("swipeGet() invoked.");
		
	} // swipeGet
	
	
	@GetMapping("/profile")
	public void profileGet() {
		log.debug("profileGet() invoked.");
		
//		return "matching/profile";
	} // profileGet
	
	
	@PostMapping("/like")
	public void likePost() {
		log.debug("likePost() invoked.");
		
//		return "matching/like";
	} // likePost
	
	
} // end class
