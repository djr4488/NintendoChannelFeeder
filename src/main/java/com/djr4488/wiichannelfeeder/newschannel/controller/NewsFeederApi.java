package com.djr4488.wiichannelfeeder.newschannel.controller;

import com.djr4488.wiichannelfeeder.newschannel.service.NewsFeederService;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
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
	@Inject
	private NewsFeederService newsFeederService;

	@Path("{region}/{file}")
	@GET
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public File handleNewsFileRequest(@PathParam("region") String region,
	                                      @PathParam("file") String file, @Context HttpServletRequest request) {
		log.info("handleNewsFileRequest() app:News Channel, region:{}, file:{}, requestURL:{}," +
				"requestIP:{}", region, file, request.getRequestURL(), request.getRemoteAddr());
		return newsFeederService.getNewsFile(file);
	}
}
