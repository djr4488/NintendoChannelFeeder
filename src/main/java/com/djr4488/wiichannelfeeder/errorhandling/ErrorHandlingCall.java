package com.djr4488.wiichannelfeeder.errorhandling;

public interface ErrorHandlingCall<T> {
    void cancel();
    void enqueue(ErrorHandlingCallback<T> callback);
}
