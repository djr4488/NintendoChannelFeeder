package com.djr4488.wiichannelfeeder.errorhandling;

import retrofit2.Response;

import java.io.IOException;

public interface ErrorHandlingCallback<T> {
    void success(Response<T> response);
    void unauthenticated(Response<?> response);
    void clientError(Response<?> response);
    void serverError(Response<?> response);
    void networkError(IOException e);
    void unexpectedError(Throwable t);
}
