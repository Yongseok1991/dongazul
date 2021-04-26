 package com.dongazul.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String createPost(ProfileDTO dto, RedirectAttributes rttrs) throws Exception {
		log.debug("createPost() invoked");
		
		this.service.craeteProfile(dto);
		rttrs.addAttribute("email", dto.getEmail());
	
		return "redirect:/profile/info";
	} // createPost
	
	@GetMapping("/info")
	public void infoGet( Model model, String email) throws Exception {
		
		ProfileDTO profile = this.service.getProfile(email);
		
		model.addAttribute("__PROFILE__", profile);
		
		log.debug("infoGet() invoked.");

	} // infoGet
	
	@PostMapping("/update")
	public void updatePost() {
		log.debug("updatePost() invoked.");
	
	} // updatePost
	
	

} // end class
