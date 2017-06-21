package com.djr4488.wiichannelfeeder.utils;

import com.djr4488.wiichannelfeeder.errorhandling.ErrorHandlingCallAdaptorFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class TransportProducer {
    public static <T> T getTransport(Class<T> transportClass, ObjectMapper objectMapper, String baseUrl,
                                     ErrorHandlingCallAdaptorFactory errorHandlingCallAdaptorFactory) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl);
        setErrorHandlingCallAdapterFactory(errorHandlingCallAdaptorFactory, retrofitBuilder);
        setConverterFactory(objectMapper, retrofitBuilder);
        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(transportClass);
    }

    private static void setErrorHandlingCallAdapterFactory(ErrorHandlingCallAdaptorFactory errorHandlingCallAdaptorFactory, Retrofit.Builder retrofitBuilder) {
        if (null != errorHandlingCallAdaptorFactory) {
            retrofitBuilder.addCallAdapterFactory(errorHandlingCallAdaptorFactory)  ;
        }
    }

    private static void setConverterFactory(ObjectMapper objectMapper, Retrofit.Builder retrofitBuilder) {
        if (null != objectMapper) {
            retrofitBuilder.addConverterFactory(JacksonConverterFactory.create(objectMapper))  ;
        }
    }
}
