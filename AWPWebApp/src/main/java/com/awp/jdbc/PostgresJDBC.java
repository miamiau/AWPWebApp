package com.awp.jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.awp.model.Booking;


@Stateless
public class PostgresJDBC {
	
	public Connection getDBconnection() {
		Connection conn = null;
		return conn;
	}
	
	public List<Booking> getBookings() {
		List<Booking> bookings = new ArrayList<Booking>();
		
		return bookings;
	}
	
	public void addBooking(Booking booking) {
		
	}
	
	public void removeBooking(int id) {
		
	}

}
