package com.pennant.cms.models;

import java.sql.Date;

public class User {

	private long id;
	private long userid;
	private String name;
	private String username;
	private String password;
	private int otp;
	private Date otpexp;
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public Date getOtpexp() {
		return otpexp;
	}
	public void setOtpexp(Date otpexp) {
		this.otpexp = otpexp;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	
	
}
