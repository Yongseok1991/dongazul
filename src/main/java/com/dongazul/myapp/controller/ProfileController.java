 package com.dongazul.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongazul.myapp.domain.ProfileDTO;
import com.dongazul.myapp.service.ProfileService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RequestMapping("/profile")

@Controller
public class ProfileController {
	
	@Autowired
	ProfileService service;
	
	@GetMapping("/create")
	public void createGet() {
		log.debug("createGet() invoked.");
		
		
	} // createGet
	
	@PostMapping("/create")
	public String createPost(ProfileDTO dto) throws Exception {
		log.debug("createPost() invoked");
		
		this.service.craeteProfile(dto);
		
		return "redirect:/matching/swipe";
		
	} // createPost
	
	@GetMapping("/info")
	public String infoGet(String email, HttpSession session, RedirectAttributes rttrs) throws Exception {
		log.debug("infoGet() invoked.");
		
		ProfileDTO profile = this.service.getProfile(email);
		
		log.info("\t+ profile: " + profile);
		
		if(profile == null) {
			rttrs.addFlashAttribute("email", email); // querystring
//			rttrs.addAttribute("email", email); // querystring 전송파라미터를 유지 
			return "redirect:/profile/create";
		} // if
		
		session.setAttribute("__PROFILE__", profile);
		
		return "profile/info";
	} // infoGet
	
	@PostMapping("/update")
	public void updatePost() {
		log.debug("updatePost() invoked.");
	
	} // updatePost
	
	

} // end class
