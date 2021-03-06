package com.awp.rest;

import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awp.jdbc.AWPPostgresJDBC;
import com.awp.model.Account;
import com.awp.model.Booking;

@Singleton
@Path("/awp")
public class AWPRestService {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@EJB
	AWPPostgresJDBC datasource;
	
	@GET
	@Path("/message")
	public Response printMessage() {

		String result = "HelloWorld";

		return Response.status(Status.OK.getStatusCode()).entity(result).build();

	}
	
	@GET
	@Path("/account/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam("email") String email) {
		Account account = null;
		try {
			account = datasource.getUser(email);
		}catch(SQLException e) {
			logger.error("Account could not be created!", e);
		}
		return account;
	}
	
	@POST
	@Path("/account")
	public Response createAccount(Account account) {
		try {
			datasource.createUser(account);
		}catch(SQLException e) {
			logger.error("Account could not be created!", e);
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}
	
	@POST
	@Path("/reservation")
	public Response addReservation(Booking booking) {
		try {
			datasource.addBooking(booking);
		}catch(SQLException e) {
			logger.error("Account could not be created!", e);
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

}
