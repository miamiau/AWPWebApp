package com.awp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.awp.jdbc.AWPPostgresJDBC;
import com.awp.model.Booking;

@Stateless
public class HotelAdministration {
	
	@EJB
	AWPPostgresJDBC jdbcConn;
	
//	public List<Booking> getBookings() {
//		return jdbcConn.getBookings();
//	}
//	
//	public void addBooking(Booking booking) {
//		jdbcConn.addBooking(booking);
//	}
//	
//	public void removeBooking(Booking booking) {
//		jdbcConn.removeBooking(booking.getId());
//	}

}
