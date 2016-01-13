package com.awp.model;

public class Room {

	private int id;
	private int personNb;
	private double price;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonNb() {
		return personNb;
	}
	public void setPersonNb(int personNb) {
		this.personNb = personNb;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
