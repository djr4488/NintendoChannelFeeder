package com.djr4488.wiichannelfeeder.forecastchannel.exceptionmapper;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by IMac on 3/29/2015.
 */
@ApplicationScoped
public class ForecastFeederExceptionMapper implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(Exception e) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
}
