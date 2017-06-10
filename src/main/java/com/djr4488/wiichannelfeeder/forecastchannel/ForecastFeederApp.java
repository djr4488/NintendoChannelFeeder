package com.djr4488.wiichannelfeeder.forecastchannel;

import com.djr4488.wiichannelfeeder.forecastchannel.exceptionmapper.ForecastFeederExceptionMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * djr4488
 * application to feed data to Wii starved Forecast Channel
 *
 */
@ApplicationScoped
@ApplicationPath("1")
public class ForecastFeederApp extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<>(Arrays.asList(ForecastFeederApi.class, ForecastFeederExceptionMapper.class));
	}
}
