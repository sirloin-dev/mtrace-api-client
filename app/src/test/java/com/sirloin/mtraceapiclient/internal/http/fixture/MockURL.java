package com.sirloin.mtraceapiclient.internal.http.fixture;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLStreamHandler;

@SuppressWarnings({"JavadocVariable", "MagicNumber"})
public final class MockURL {
    @SuppressWarnings({"MissingJavadocMethod"})
    public static final class MockURLStreamHandler extends URLStreamHandler {
        private final int mockResponseCode;

        public MockHttpURLConnection openConnection(final URL u) {
            MockURL.MockHttpURLConnection mockConn = new MockURL.MockHttpURLConnection(u);
            mockConn.setResponseCode(this.mockResponseCode);
            return mockConn;
        }

        public MockURLStreamHandler(final int mockResponseCode) {
            this.mockResponseCode = mockResponseCode;
        }
    }

    @SuppressWarnings({"MissingJavadocMethod"})
    public static final class MockHttpURLConnection extends HttpURLConnection {
        public void connect() {
        }

        public InputStream getInputStream() {
            return new MockURL.MockInputStream();
        }

        public InputStream getErrorStream() {
            return new MockURL.MockInputStream();
        }

        public void disconnect() {
        }

        public boolean usingProxy() {
            return false;
        }

        public void setResponseCode(final int mockResponseCode) {
            this.responseCode = mockResponseCode;
        }

        public MockHttpURLConnection(final URL u) {
            super(u);
        }
    }

    @SuppressWarnings({"MissingJavadocMethod"})
    public static final class MockInputStream extends InputStream {
        public int read() {
            return -1;
        }
    }
}
