package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.errorhandling.ErrorHandlingCall;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DarkskyTransport {
    @GET("forecast/{key}/{latitude},{longitude}")
    ErrorHandlingCall<DarkskyResponse> getForecast(@Path("key") String key, @Path("latitude") String latitude, @Path("longitude") String longitude);
}
