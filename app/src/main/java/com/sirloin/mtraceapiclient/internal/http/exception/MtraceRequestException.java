package com.sirloin.mtraceapiclient.internal.http.exception;

import javax.annotation.Nonnull;

public final class MtraceRequestException extends RuntimeException {

    private static final long serialVersionUID = 5034400802943484660L;
    /**
     * api 조회후 resultcode입니다.
     */
    private final String mtraceErrorCode;

    /**
     * 축살물 api 조회중 resultcode가 00이 아닌 실패시 발생하는 예외입니다.
     * @param errorMessage resultMsg
     * @param mtraceErrorCode resultcode
     */
    public MtraceRequestException(
            @Nonnull final String errorMessage,
            @Nonnull final String mtraceErrorCode
    ) {
        super(errorMessage);
        this.mtraceErrorCode = mtraceErrorCode;
    }

    /**
     * @return api 조회후 resultcode입니다.
     */
    public String getMtraceErrorCode() {
        return mtraceErrorCode;
    }
}
