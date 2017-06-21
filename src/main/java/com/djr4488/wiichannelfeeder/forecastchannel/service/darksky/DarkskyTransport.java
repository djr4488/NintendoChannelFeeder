package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DarkskyTransport {
    @GET("forecast/{key}/{latitude},{longitude}")
    Call<DarkskyResponse> getForecast(@Path("key") String key, @Path("latitude") String latitude,
                                   @Path("longitude") String longitude, @Query("lang") String language,
                                   @Query("units") String units, @Query("timezone") String timezone);
}
