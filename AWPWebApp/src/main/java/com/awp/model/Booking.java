package com.awp.model;

import java.util.Date;

public class Booking {
	
	private int id;
	private int roomId;
	private Date startDate;
	private Date endDate;
	
	public int getId() {
		return id;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
