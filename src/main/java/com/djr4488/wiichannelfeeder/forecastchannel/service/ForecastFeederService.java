package com.djr4488.wiichannelfeeder.forecastchannel.service;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyTransport;
import org.slf4j.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

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
	@Inject
	private DarkskyTransport darkskyTransport;
	//todo setup inject using a config service
	private String key;

	@Schedule(second="0", minute="0/1", hour="*")
	public void getUpdatedForecastsByRegions() {
		log.info("getUpdateForecastByRegions() started");
		String darkskyJsonAsString = null;
		try {
			darkskyJsonAsString = darkskyTransport.getForecast(key, "38.881396", "-94.819128").execute().body().string();
		} catch (IOException ioEx) {
			log.error("getUpdateForecastsByRegions() error", ioEx);
		}
		log.info("getUpdateForecastByRegions() completed with darkskyJsonAsString:{}", darkskyJsonAsString);
	}

	public File getForecastFile(String region, String file) {
		//for now just return the existing file
		log.debug("getForecastFile() region:{}, file:{}", region, file);
		return new File("c:/app/wiichannels/" + file);
	}
}
