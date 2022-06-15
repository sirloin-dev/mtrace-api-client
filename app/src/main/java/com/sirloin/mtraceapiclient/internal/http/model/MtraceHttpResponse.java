package com.sirloin.mtraceapiclient.internal.http.model;

import javax.annotation.Nonnull;
import java.io.InputStream;

/**
 * 해당 프로젝트 전용 response 객체입니다.
 */
public class MtraceHttpResponse {
    /**
     * 요청한 http method.
     */
    @Nonnull
    private final MtraceHttpMethod method;

    /**
     * 응답 코드.
     */
    private final int statusCode;

    /**
     * 응답 body.
     */
    @Nonnull
    private final InputStream body;

    /**
     * 기본 생성자.
     * @param method 요청한 http method
     * @param statusCode 응답 코드.
     * @param body 응답 body.
     */
    public MtraceHttpResponse(
            final @Nonnull MtraceHttpMethod method,
            final int statusCode,
            final @Nonnull InputStream body
    ) {
        this.method = method;
        this.statusCode = statusCode;
        this.body = body;
    }

    /**
     * @return 요청한 http method
     */
    @Nonnull
    public MtraceHttpMethod getMethod() {
        return method;
    }

    /**
     * @return 응답 코드.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return 응답 body.
     */
    @Nonnull
    public InputStream getBody() {
        return body;
    }
}
