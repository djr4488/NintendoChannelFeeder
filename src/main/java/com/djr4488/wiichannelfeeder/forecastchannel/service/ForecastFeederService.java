package com.djr4488.wiichannelfeeder.forecastchannel.service;

import org.slf4j.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;

/**
 * djr4488
 * Service to get forecast data and build forecast files as required by Wii Forecast channel
 *
 */
@Startup
@Singleton
public class ForecastFeederService {
	@Inject
	private Logger log;

	@Schedule(second="0", minute="0", hour="12/4")
	public void getUpdatedForecastsByRegions() {
		log.info("getUpdateForecastByRegions() started");
		log.debug("getUpdateForecastByRegions() completed");
	}

	public File getForecastFile(String region, String file) {
		//for now just return the existing file
		log.debug("getForecastFile() region:{}, file:{}", region, file);
		return new File("c:/app/wiichannels/" + file);
	}
}
