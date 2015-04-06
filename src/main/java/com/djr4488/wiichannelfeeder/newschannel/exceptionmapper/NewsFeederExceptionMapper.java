package com.djr4488.wiichannelfeeder.newschannel.exceptionmapper;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by IMac on 3/31/2015.
 */
@ApplicationScoped
public class NewsFeederExceptionMapper implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(Exception e) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
}
