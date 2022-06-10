package com.sirloin.mtraceapiclient.internal.http.exception;

import javax.validation.constraints.NotNull;
import java.io.Serial;

public final class MtraceHttpConnectException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2338626292552177485L;

    public MtraceHttpConnectException(@NotNull String errorMessage, @NotNull Exception originalException) {
        super(errorMessage, originalException);
    }
}
