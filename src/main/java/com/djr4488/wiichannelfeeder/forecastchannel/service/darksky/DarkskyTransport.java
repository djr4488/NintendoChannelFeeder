package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DarkskyTransport {
    @GET("forecast/{key}/{latitude},{longitude}")
    Call<ResponseBody> getForecast(@Path("key") String key, @Path("latitude") String latitude, @Path("longitude") String longitude);
}
