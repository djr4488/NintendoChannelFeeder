package com.djr4488.wiichannelfeeder.forecastchannel.service;

import com.djr4488.wiichannelfeeder.errorhandling.ErrorHandlingCall;
import com.djr4488.wiichannelfeeder.errorhandling.ErrorHandlingCallback;
import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyResponse;
import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyTransport;
import org.slf4j.Logger;
import retrofit2.Response;

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
	private String key = "my key";

	@Schedule(second="0", minute="0/1", hour="*")
	public void getUpdatedForecastsByRegions() {
		log.info("getUpdateForecastByRegions() started");
		darkskyTransport.getForecast(key, "38.881396", "-94.819128").enqueue(
			new ErrorHandlingCallback<DarkskyResponse>() {
				DarkskyResponse darkskyJsonAsString;
				@Override
				public void success(Response<DarkskyResponse> response) {
					System.out.println("SUCCESS!!!! " + response.body().toString());
					darkskyJsonAsString = response.body();
					log.debug("darkskyJsonAsString:{}", darkskyJsonAsString);
				}

				@Override
				public void unauthenticated(Response<?> response) {
					System.out.println("Not authenticated");
				}

				@Override
				public void clientError(Response<?> response) {
					System.out.println("Client Error " + response.code() + " " + response.message());
				}

				@Override
				public void serverError(Response<?> response) {
					System.out.println("Server Error " + response.code() + " " + response.message());
				}

				@Override
				public void networkError(IOException e) {
					System.err.println("Network Error " + e.getMessage());
				}

				@Override
				public void unexpectedError(Throwable t) {
					System.err.println("Fatal Error " + t.getMessage());
				}
			}
		);  // end getForecast
	}

	public File getForecastFile(String region, String file) {
		//for now just return the existing file
		log.debug("getForecastFile() region:{}, file:{}", region, file);
		return new File("c:/app/wiichannels/" + file);
	}
}
