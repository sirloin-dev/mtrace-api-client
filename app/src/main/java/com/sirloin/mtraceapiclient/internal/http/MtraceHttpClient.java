package com.sirloin.mtraceapiclient.internal.http;

import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpRequest;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpResponse;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.function.Function;

public interface MtraceHttpClient {
    /**
     * Http Get 통신 메서드입니다.
     *
     * @param request
     * @return MtraceHttpResponse
     * @throws MalformedURLException
     * @throws ProtocolException
     */
    MtraceHttpResponse get(
            MtraceHttpRequest request
    ) throws MalformedURLException, ProtocolException, UnsupportedEncodingException;

    /**
     * 해당 인터페이스의 기본 구현체입니다.
     * @return MtraceHttpClientImpl
     */
    static MtraceHttpClient newInstance() {
        return new MtraceHttpClientImpl(defaultUrlFactory());
    }

    /**
     * @return new URL(url);
     */
    static Function<String, URL> defaultUrlFactory() {
        return url -> {
            try {
                return new URL(url);
            } catch (MalformedURLException e) {
                throw new IllegalStateException("URL이 잘못되었습니다.", e);
            }
        };
    }
}
