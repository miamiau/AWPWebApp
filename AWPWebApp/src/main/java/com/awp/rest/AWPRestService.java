package com.awp.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@EJB
@Path("awp")
public class AWPRestService {
	
	@GET
	@Path("")
	public Response printMessage() {

		String result = "HelloWorld";

		return Response.status(200).entity(result).build();

	}

}
