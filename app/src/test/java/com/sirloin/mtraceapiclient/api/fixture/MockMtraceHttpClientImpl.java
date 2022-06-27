package com.sirloin.mtraceapiclient.api.fixture;

import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpMethod;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpRequest;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpResponse;

import java.io.InputStream;

@SuppressWarnings({"MissingJavadocMethod", "JavadocVariable", "MagicNumber"})
public final class MockMtraceHttpClientImpl implements MtraceHttpClient {
    private final InputStream responseBody;

    public MtraceHttpResponse get(final MtraceHttpRequest request) {
        return new MtraceHttpResponse(MtraceHttpMethod.GET, 200, this.responseBody);
    }

    public MockMtraceHttpClientImpl(final InputStream responseBody) {
        this.responseBody = responseBody;
    }
}
