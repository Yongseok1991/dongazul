package com.dongazul.myapp.domain;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class MemberVO {
	private String email;
	private String passwd;
	private Integer phonenumber;
	private Timestamp time;
} // end class
