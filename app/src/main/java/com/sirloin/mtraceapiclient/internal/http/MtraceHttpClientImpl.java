package com.sirloin.mtraceapiclient.internal.http;

import com.sirloin.mtraceapiclient.internal.http.exception.MtraceHttpConnectException;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpMethod;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpRequest;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

final class MtraceHttpClientImpl implements MtraceHttpClient {
    public static final int HTTP_OK = 200;
    public static final int HTTP_OK_END = 299;
    private final Function<String, URL> urlFactory;

    MtraceHttpClientImpl(Function<String, URL> urlFactory) {
        this.urlFactory = urlFactory;
    }

    @Override
    public MtraceHttpResponse get(MtraceHttpRequest request) throws Exception {
        HttpURLConnection conn = this.connect(request.url());
        conn.setRequestMethod(MtraceHttpMethod.GET.name());
        return this.httpResponse(conn);
    }

    private HttpURLConnection connect(String apiUrl) throws Exception {
        try {
            return (HttpURLConnection) urlFactory.apply(apiUrl).openConnection();
        } catch (MalformedURLException e) {
            throw new MalformedURLException("URL이 잘못되었습니다. : " + apiUrl);
        } catch (IOException e) {
            throw new MtraceHttpConnectException("연결에 실패했습니다. : " + apiUrl, e);
        }
    }

    private MtraceHttpResponse httpResponse(HttpURLConnection con) throws Exception {
        try {
            return this.call(con);
        } catch (Exception e) {
            throw new MtraceHttpConnectException("Http 요청에 실패하였습니다.", e);
        } finally {
            con.disconnect();
        }
    }

    private MtraceHttpResponse call(HttpURLConnection con) throws Exception {
        if (HTTP_OK <= con.getResponseCode() && con.getResponseCode() <= HTTP_OK_END) {
            return new MtraceHttpResponse(
                    MtraceHttpMethod.valueOf(con.getRequestMethod()),
                    con.getResponseCode(),
                    copyInputStream(con.getInputStream())
            );
        } else {
            return new MtraceHttpResponse(
                    MtraceHttpMethod.valueOf(con.getRequestMethod()),
                    con.getResponseCode(),
                    copyInputStream(con.getErrorStream())
            );
        }
    }

    private ByteArrayInputStream copyInputStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        inputStream.transferTo(baos);
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
