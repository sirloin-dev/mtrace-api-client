package com.sirloin.mtraceapiclient.internal.http.exception;

import javax.annotation.Nonnull;


public final class MtraceHttpConnectException extends RuntimeException {

    private static final long serialVersionUID = -7899052229933582128L;

    /**
     * Mtrace http 조회중 connect 에러시 발생하는 예외입니다.
     * @param errorMessage
     * @param originalException
     */
    public MtraceHttpConnectException(@Nonnull final String errorMessage, @Nonnull final Exception originalException) {
        super(errorMessage, originalException);
    }
}
