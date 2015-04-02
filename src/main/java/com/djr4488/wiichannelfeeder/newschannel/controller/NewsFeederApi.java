package com.djr4488.wiichannelfeeder.newschannel.controller;

import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * djr4488
 * Api to handle NewsFileRequest
 * Will eventually generate and feed files to Wii News Channel
 */
@ApplicationScoped
@Path("1")
public class NewsFeederApi {
	@Inject
	private Logger log;

	@Path("{region}/{file}")
	@GET
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response handleNewsFileRequest(@PathParam("region") String region,
	                                      @PathParam("file") String file, @Context HttpServletRequest request) {
		log.info("handleNewsFileRequest() app:News Channel, region:{}, file:{}, requestURL:{}, reqeustPath:{}, requestIP:{}",
				region, file, request.getRequestURL(), request.getContextPath(), request.getRemoteUser());
		Response response;
		File newsBinFile = new File("c:/app/wiichannels/news/"+file);
		response = Response.status(Response.Status.OK).entity(newsBinFile).build();
		return response;
	}
}
