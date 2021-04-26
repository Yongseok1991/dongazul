package com.dongazul.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
	
	private String email;
	private String nickname;
	private Integer age;
	private String gender;
	private String zone;
	private String introduce;
	private String iname;

} // end class
