package internal.http.model;

import javax.validation.constraints.NotNull;
import java.io.InputStream;

public record MtraceHttpResponse(
        @NotNull MtraceHttpMethod method,
        int statusCode,
        @NotNull InputStream body
) {

}
