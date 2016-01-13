package com.awp.rest;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Singleton
@Path("/awp")
public class AWPRestService {
	
	@GET
	@Path("/message")
	public Response printMessage() {

		String result = "HelloWorld";

		return Response.status(200).entity(result).build();

	}

}
