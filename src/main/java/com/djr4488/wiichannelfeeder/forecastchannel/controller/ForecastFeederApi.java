package com.djr4488.wiichannelfeeder.forecastchannel.controller;

import com.djr4488.wiichannelfeeder.forecastchannel.service.ForecastFeederService;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
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
	@Inject
	private ForecastFeederService forecastFeederService;

	@Path("{region}/{file}")
	@GET
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public File handleForecastFileRequest(@PathParam("region") String region,
	                                          @PathParam("file") String file, @Context HttpServletRequest request,
	                                          @Context HttpServletResponse response) {
		log.info("handleForecastFileRequest() app:Forecast Channel, region:{}, file:{}, requestURL:{}," +
				"requestIP:{}", region, file, request.getRequestURL(), request.getRemoteAddr());
		return forecastFeederService.getForecastFile(region, file);
	}
}
