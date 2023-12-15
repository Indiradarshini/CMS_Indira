package com.pennant.cms.models;

import java.sql.Date;

public class Seat {

	private long id;
	private int seatno;
	private long userid;
	private String status;
	private Date blockedtime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSeatno() {
		return seatno;
	}

	public String getStatus() {
		return status;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBlockedtime() {
		return blockedtime;
	}

	public void setBlockedtime(Date blockedtime) {
		this.blockedtime = blockedtime;
	}

}
