package com.sirloin.mtraceapiclient.internal.http.exception;

import javax.validation.constraints.NotNull;
import java.io.Serial;

public final class MtraceHttpConnectException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2338626292552177485L;


    /**
     * Mtrace http 조회중 connect 에러시 발생하는 예외입니다.
     * @param errorMessage
     * @param originalException
     */
    public MtraceHttpConnectException(@NotNull final String errorMessage, @NotNull final Exception originalException) {
        super(errorMessage, originalException);
    }
}
