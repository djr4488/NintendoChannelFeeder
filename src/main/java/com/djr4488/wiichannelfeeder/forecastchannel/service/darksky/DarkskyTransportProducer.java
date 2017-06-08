package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.errorhandling.ErrorHandlingCallAdaptorFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_GETTERS;
import static com.fasterxml.jackson.databind.MapperFeature.REQUIRE_SETTERS_FOR_GETTERS;
import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

@ApplicationScoped
public class DarkskyTransportProducer {
    @Inject
    private Logger log;
    //todo configure a config service
    private String baseUrl = "https://api.darksky.net/";

    @Produces
    public DarkskyTransport getDarkskyTransport() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(new ErrorHandlingCallAdaptorFactory())
                .addConverterFactory(JacksonConverterFactory.create(getObjectMapper()))
                .build();
        return retrofit.create(DarkskyTransport.class);
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper result = new ObjectMapper();
        result.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        result.configure(REQUIRE_SETTERS_FOR_GETTERS, false);
        result.configure(AUTO_DETECT_GETTERS, true);
        result.configure(INDENT_OUTPUT, true);
        result.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return result;
    }
}
