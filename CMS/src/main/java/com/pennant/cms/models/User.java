package com.pennant.cms.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private long id;
	private long userid;
	private String name;
	private String username;
	@JsonIgnore
	private String password;
	private int otp;
	private Date otpexp;
	private int seatno;
	private String status;
	private Date bookedtime;

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

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBookedtime() {
		return bookedtime;
	}

	public void setBookedtime(Date bookedtime) {
		this.bookedtime = bookedtime;
	}

}
