package com.sirloin.mtraceapiclient.internal.http;

import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpRequest;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpResponse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

public interface MtraceHttpClient {
    /**
     * Http Get 통신 메서드입니다.
     * @param request
     * @return MtraceHttpResponse
     */
    MtraceHttpResponse get(MtraceHttpRequest request) throws Exception;

    /**
     * 해당 인터페이스의 기본 구현체입니다.
     * @return MtraceHttpClientImpl
     */
    static MtraceHttpClient newInstance() {
        return new MtraceHttpClientImpl(defaultUrlFactory());
    }

    private static Function<String, URL> defaultUrlFactory() {
        return url -> {
            try {
                return new URL(url);
            } catch (MalformedURLException e) {
                throw new IllegalStateException("URL이 잘못되었습니다.", e);
            }
        };
    }
}
