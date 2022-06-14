package com.sirloin.mtraceapiclient.internal.http.fixture;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLStreamHandler;

public final class MockURL {

    public static final class MockURLStreamHandler extends URLStreamHandler {
        private final int mockResponseCode;

        public MockHttpURLConnection openConnection(final URL u) {
            MockURL.MockHttpURLConnection mockConn = new MockURL.MockHttpURLConnection(u);
            mockConn.setResponseCode(this.mockResponseCode);
            return mockConn;
        }

        public MockURLStreamHandler(int mockResponseCode) {
            this.mockResponseCode = mockResponseCode;
        }
    }

    public static final class MockHttpURLConnection extends HttpURLConnection {
        public void connect() {
        }

        public InputStream getInputStream() {
            return (InputStream) (new MockURL.MockInputStream());
        }

        public InputStream getErrorStream() {
            return (InputStream) (new MockURL.MockInputStream());
        }

        public void disconnect() {
        }

        public boolean usingProxy() {
            return false;
        }

        public final void setResponseCode(int mockResponseCode) {
            this.responseCode = mockResponseCode;
        }

        public MockHttpURLConnection(URL u) {
            super(u);
        }
    }

    public static final class MockInputStream extends InputStream {
        public int read() {
            return -1;
        }
    }
}

