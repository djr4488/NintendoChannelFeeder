package com.djr4488.wiichannelfeeder.forecastchannel;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyCallback;
import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyResponse;
import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyTransport;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.City;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.Forecast;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.ForecastStoreService;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.RegionalForecast;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.djr.retrofit2ee.json.*;
import org.slf4j.Logger;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
	@JacksonModule(jacksonModules = {com.fasterxml.jackson.datatype.jsr310.JavaTimeModule.class})
	@JacksonMapperFeature(features = {
			@MapperFeatureConfig(feature = MapperFeature.REQUIRE_SETTERS_FOR_GETTERS, value = false),
			@MapperFeatureConfig(feature = MapperFeature.AUTO_DETECT_GETTERS, value = true)})
	@JacksonSerializationFeature(features = {
			@SerializationFeatureConfig(feature = SerializationFeature.INDENT_OUTPUT, value = true)})
	@JacksonDeserializationFeature(features = {
			@DeserializationFeatureConfig(feature = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, value = false)})
	@Inject
	@RetrofitJson(captureTrafficLogsPropertyName = "Darksky.enableTrafficLogging",
			baseUrlPropertyName = "Darksky.baseUrl")
	private Retrofit retrofitJson;
	private DarkskyTransport darkskyTransport;
	@Inject
	private ForecastStoreService forecastStoreService;
	@Inject
	private Event<DarkskyResponse> darkskyResponseBus;

	//todo setup inject using a config service
	private String key = "key";

	@PostConstruct
	private void postConstruct() {
		darkskyTransport = retrofitJson.create(DarkskyTransport.class);
	}

	@Schedule(second="0", minute="0/1", hour="*")
	public void getUpdatedForecastsByRegions()
	throws IOException {
		String threadName = Thread.currentThread().getName();
		DarkskyResponse resp =
				darkskyTransport.getForecast(key, "38.8733", "-94.7752", "en", "us", "cst")
					.execute()
					.body();
		log.info("getUpdateForecastByRegions() resp:{}", resp);
		log.info("getUpdateForecastByRegions() started threadName:{}", threadName);
//		List<RegionalForecast> regionalForecasts = forecastStoreService.getRegions();
//		for (RegionalForecast regionalForecast : regionalForecasts) {
//			//TODO consider; denormalize db to avoid this loop?  only supporting 7 and not many regionalForecasts
//			//TODO so maybe not needed
//			forecastStoreService.deleteExistingForecastsForRegion(regionalForecast);
//			List<City> cities = regionalForecast.getCities();
//			for (City city : cities) {
//				DarkskyResponse response;
//				try {
//					response = darkskyTransport.getForecast(key, city.getLatitude(), city.getLongitude(),
//							regionalForecast.getLanguage(), regionalForecast.getUnits(), city.getTimezone()).execute().body();
//				} catch (IOException ioEx) {
//					log.error("getUpdatedForecastByRegions() failed obtaining forecast for city:{}", city, ioEx);
//					continue;
//				}
//				response.setRegionCode("049");
//				darkskyResponseBus.fire(response);
//				log.debug("getUpdatedForecastByRegions() response:{}", response);
//			}
//		}
	}

	public File getForecastFile(String region, String file) {
		//for now just return the existing file
		log.debug("getForecastFile() region:{}, file:{}", region, file);
		return new File("c:/app/wiichannels/" + file);
	}

	public void darkskyResponseHandler(@Observes DarkskyResponse response) {
		String threadName = Thread.currentThread().getName();
		log.debug("darkskyResponseListener() darkskyResponse:{}, threadName:{}", response, threadName);
		try {
			RegionalForecast regionalForecast = forecastStoreService.getRegion(response.getRegionCode());
			Forecast forecast = forecastStoreService.saveForecastForLocation(response, regionalForecast);
			forecastStoreService.saveForecastDataPoints(response, forecast);
		} catch (Exception ex) {
			log.error("darkskyResponseListener() ", ex);
		}
	}
}
