package com.djr4488.wiichannelfeeder.forecastchannel;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyCallback;
import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyResponse;
import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyTransport;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.ForecastStoreService;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.Location;
import org.slf4j.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.File;

/**
 * djr4488
 * Service to get forecast data and build forecast files as required by Wii Forecast channel
 *
 */
@Startup
@Singleton
public class ForecastFeederController {
	@Inject
	private Logger log;
	@Inject
	private DarkskyTransport darkskyTransport;
	@Inject
	private DarkskyCallback darkskyCallback;
	@Inject
	private ForecastStoreService forecastStoreService;

	//todo setup inject using a config service
	private String key = "key";

	@Schedule(second="0", minute="0/1", hour="*")
	public void getUpdatedForecastsByRegions() {
		String threadName = Thread.currentThread().getName();
		log.info("getUpdateForecastByRegions() started threadName:{}", threadName);
		//darkskyTransport.getForecast(key, "38.881396", "-94.819128")
		//		.enqueue(darkskyCallback);
	}

	public File getForecastFile(String region, String file) {
		//for now just return the existing file
		log.debug("getForecastFile() region:{}, file:{}", region, file);
		return new File("c:/app/wiichannels/" + file);
	}

	public void darkskyResponseHandler(DarkskyResponse darkskyResponse) {
		String threadName = Thread.currentThread().getName();
		log.debug("darkskyResponseListener() darkskyResponse:{}, threadName:{}", darkskyResponse, threadName);
		try {
			forecastStoreService.saveForecastForLocation(darkskyResponse);
		} catch (Exception ex) {
			log.error("darkskyResponseListener() ", ex);
		}
		//TODO call forecast store service to save data to database
	}
}
