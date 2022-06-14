package com.sirloin.mtraceapiclient.internal.http;

import com.sirloin.mtraceapiclient.internal.http.fixture.MockURL;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpMethod;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpRequest;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MtraceHttpClientImplTest {

    private static final String TEST_URL = "https://testurl";

    @DisplayName("Http get 요청 후 200응답을 받습니다.")
    @Test
    void Http_get_request_is_successful() throws Exception {
        //given
        MtraceHttpClientImpl sut = new MtraceHttpClientImpl(mockURL(HTTP_OK));
        Map<String, Object> param = new HashMap<>();
        param.put("test", "test");
        MtraceHttpRequest request = new MtraceHttpRequest(TEST_URL, param);

        //when
        MtraceHttpResponse response = sut.get(request);

        //then
        assertAll(
                () -> assertThat(request.url(), is("https://testurl?test=test")),
                () -> assertThat(response.method(), is(MtraceHttpMethod.GET)),
                () -> assertThat(response.statusCode(), is(HTTP_OK))
        );
    }

    @DisplayName("Http get 요청 후 400응답을 받습니다.")
    @Test
    void Http_get_request_fails() throws Exception {
        //given
        MtraceHttpClientImpl sut = new MtraceHttpClientImpl(mockURL(HTTP_BAD_REQUEST));
        Map<String, Object> param = new HashMap<>();
        param.put("test", "test");
        MtraceHttpRequest request = new MtraceHttpRequest(TEST_URL, param);

        //when
        MtraceHttpResponse response = sut.get(request);

        //then
        assertAll(
                () -> assertThat(request.url(), is("https://testurl?test=test")),
                () -> assertThat(response.method(), is(MtraceHttpMethod.GET)),
                () -> assertThat(response.statusCode(), is(HTTP_BAD_REQUEST))
        );
    }

    private Function<String, URL> mockURL(int code) {
        return it -> {
            try {
                return new URL(null, it, new MockURL.MockURLStreamHandler(code));
            } catch (MalformedURLException e) {
                throw new IllegalStateException("test url", e);
            }
        };
    }
}