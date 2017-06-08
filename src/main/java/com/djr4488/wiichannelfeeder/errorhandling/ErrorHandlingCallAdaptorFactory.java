package com.djr4488.wiichannelfeeder.errorhandling;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

public class ErrorHandlingCallAdaptorFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations,
                                           Retrofit retrofit) {
        if (getRawType(returnType) != ErrorHandlingCall.class) {
            return null;
        }
        if (!(returnType instanceof ParameterizedType)) {
            throw new IllegalStateException(
                    "ErrorHandlingCall must have generic type (e.g., ErrorHandlingCall<ResponseBody>)");
        }
        Type responseType = getParameterUpperBound(0, (ParameterizedType) returnType);
        Executor callbackExecutor = retrofit.callbackExecutor();
        return new ErrorHandlingCallAdapter<>(responseType, callbackExecutor);
    }

    private class ErrorHandlingCallAdapter<R> implements CallAdapter<R, ErrorHandlingCall<R>> {
        private final Type responseType;
        private final Executor callbackExecutor;

        ErrorHandlingCallAdapter(Type responseType, Executor callbackExecutor) {
            this.responseType = responseType;
            this.callbackExecutor = callbackExecutor;
        }

        @Override
        public Type responseType() {
            return responseType;
        }

        @Override
        public ErrorHandlingCall<R> adapt(Call<R> call) {
            return new ErrorHandlingAdapter<>(call, callbackExecutor);
        }
    }
}
