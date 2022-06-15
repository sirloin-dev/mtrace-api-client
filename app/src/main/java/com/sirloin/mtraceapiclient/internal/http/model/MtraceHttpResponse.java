package com.sirloin.mtraceapiclient.internal.http.model;

import javax.annotation.Nonnull;
import java.io.InputStream;

public record MtraceHttpResponse(
        @Nonnull MtraceHttpMethod method,
        int statusCode,
        @Nonnull InputStream body
) {

}
