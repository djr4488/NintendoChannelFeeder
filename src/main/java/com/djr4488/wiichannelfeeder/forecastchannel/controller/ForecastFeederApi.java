package com.djr4488.wiichannelfeeder.forecastchannel.controller;

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
 * Api to handle ForecastFileRequest
 * Will eventually generate and feed files to Wii Forecast Channel
 */
@ApplicationScoped
public class ForecastFeederApi {
	@Inject
	private Logger log;

	@Path("{region}/{file}")
	@GET
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response handleForecastFileRequest(@PathParam("region") String region,
	                                          @PathParam("file") String file, @Context HttpServletRequest request) {
		log.info("handleForecastFileRequest() app:Forecast Channel, region:{}, file:{}, requestURL:{}," +
				"requestIP:{}", region, file, request.getRequestURL(), request.getRemoteAddr());
		Response response;
		if (file.equals("forecast.bin")) {
			File forecastBinFile = new File("c:/app/wiichannels/forecast.bin");
			response = Response.status(Response.Status.OK).entity(forecastBinFile).build();
		} else {
			File shortBinFile = new File("c:/app/wiichannels/short.bin");
			response = Response.status(Response.Status.OK).entity(shortBinFile).build();
		}
		return response;
	}
}
