 package com.dongazul.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RequestMapping("/profile")

@Controller
public class ProfileController {
	
	@GetMapping("/create")
	public void createGet() {
		log.debug("createGet() invoked.");

	} // createGet
	
	@PostMapping("/create")
	public void createPost() {
		log.debug("createPost() invoked");
	
	} // createPost
	
	@GetMapping("/info")
	public void infoGet() {
		log.debug("infoGet() invoked.");

	} // infoGet
	
	@PostMapping("/update")
	public void updatePost() {
		log.debug("updatePost() invoked.");
	
	} // updatePost
	
	

} // end class
