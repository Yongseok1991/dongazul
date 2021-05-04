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

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	ProfileService service;
	
	private static final String saveDir = "/resources/upload/file";
	
	@GetMapping("/create")
	public void createGet() {
		
		log.debug("createGet() invoked.");
	} // createGet
	
	@PostMapping("/create")
	public String createPost(ProfileDTO dto) throws Exception {
		
		log.debug("createPost() invoked");
//		MultipartFile multipart = dto.getMultipart();
//		
//		Date now = new Date();
//		
//		DateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
//		String yyyyMMdd = formatter.format(now); 
//		int random = (int)(Math.random()*1000);
//		
//		if(multipart.isEmpty()) {
//			
//			try {
//				File lastUploadDir = new File(saveDir + "/" + yyyyMMdd);
//				
//				if(!lastUploadDir.exists()) {
//					lastUploadDir.mkdir();
//				}
//				String filename = multipart.getOriginalFilename();
//				FileOutputStream fos = new FileOutputStream(lastUploadDir + "/" + filename+random);
//				BufferedOutputStream bos = new BufferedOutputStream(fos);
//				String imageroot = lastUploadDir + "/" + filename+random;
//				dto.setImageroot(imageroot);
//				try(fos; bos;) {
//					
//					byte[] fileData = multipart.getBytes();
//					bos.write(fileData);
//					
//					bos.flush();
//				} // try-with-resources
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}

		this.service.craeteProfile(dto);
		
		return "redirect:/matching/swipe";
	} // createPost
	
	@GetMapping("/info")
	public String infoGet(
			String email,
			HttpSession session, 
			RedirectAttributes rttrs
			) throws Exception {
		
		log.debug("infoGet() invoked.");
		
		ProfileDTO profile = this.service.getProfile(email);
		
		if(profile == null) {
			
//			rttrs.addFlashAttribute("email", email); 
			rttrs.addAttribute("email", email); // querystring 전송파라미터를 유지 
			return "redirect:/profile/create";
		} // if
		session.setAttribute("__PROFILE__", profile);
		
		return "profile/info";
	} // infoGet
	
	@GetMapping("/update")
	public void updateGet() {
		log.debug("updateGet() invoked.");
		
	} // updatePost
	
	@PostMapping("/update")
	public String updatePost(ProfileDTO profile, RedirectAttributes rttrs) throws Exception {
		
		log.debug("updatePost() invoked.");
		
		if(this.service.modifyProfile(profile)) {
			
			rttrs.addFlashAttribute("msg", "수정이 완료되었습니다.");
		} // if
		
		return "redirect:/matching/swipe";
	} // updatePost
	
} // end class
