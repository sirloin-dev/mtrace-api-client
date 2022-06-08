package com.sirloin.mtrace.util.http.mock

import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLStreamHandler

class MockURL {
    class MockURLStreamHandler(private val mockResponseCode: Int) : URLStreamHandler() {
        override fun openConnection(u: URL?): MockHttpURLConnection {
            return MockHttpURLConnection(u).apply { responseCode = mockResponseCode }
        }
    }

    class MockHttpURLConnection(u: URL?) : HttpURLConnection(u) {

        // mock을 위한 구현체라 detekt의 빈 코드블록 경고는 무시하였습니다.
        @Suppress("EmptyFunctionBlock")
        override fun connect() {
        }

        override fun getInputStream(): InputStream {
            return MockInputStream()
        }

        override fun getErrorStream(): InputStream {
            return MockInputStream()
        }

        // mock을 위한 구현체라 detekt의 빈 코드블록 경고는 무시하였습니다.
        @Suppress("EmptyFunctionBlock")
        override fun disconnect() {
        }

        override fun usingProxy(): Boolean {
            return false
        }

        fun setResponseCode(mockResponseCode: Int) {
            responseCode = mockResponseCode
        }
    }

    class MockInputStream : InputStream() {
        override fun read(): Int {
            return -1
        }
    }

}
