package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.errorhandling.ErrorHandlingCallback;
import org.slf4j.Logger;
import retrofit2.Response;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class DarkskyCallback implements ErrorHandlingCallback<DarkskyResponse> {
    @Inject
    private Logger log;
    @Inject
    private Event<DarkskyResponse> darkskyResponseBus;

    public DarkskyCallback() {}

    @Override
    public void success(Response<DarkskyResponse> response) {
        log.debug("success() firing event for response:{} and body:{}", response, response.body());
        darkskyResponseBus.fire(response.body());
    }

    @Override
    public void unauthenticated(Response<?> response) {
        log.debug("unauthenticated() response:{}", response);
    }

    @Override
    public void clientError(Response<?> response) {
        log.debug("clientError() response:{}", response);
    }

    @Override
    public void serverError(Response<?> response) {
        log.debug("serverError() response:{}", response);
    }

    @Override
    public void networkError(IOException e) {
        log.error("networkError() ", e);
    }

    @Override
    public void unexpectedError(Throwable t) {
        log.error("unexpectedError() ", t);
    }
}
