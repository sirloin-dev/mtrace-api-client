package com.sirloin.mtraceapiclient.internal.http;

import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpRequest;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpResponse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

public interface MtraceHttpClient {
    MtraceHttpResponse get(MtraceHttpRequest request) throws Exception;

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
