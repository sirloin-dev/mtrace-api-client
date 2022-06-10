package com.sirloin.mtraceapiclient.internal.http.exception;


import javax.validation.constraints.NotNull;

public final class MtraceHttpConnectException extends RuntimeException {
    public MtraceHttpConnectException(@NotNull String errorMessage, @NotNull Exception originalException) {
        super(errorMessage, originalException);
    }
}
