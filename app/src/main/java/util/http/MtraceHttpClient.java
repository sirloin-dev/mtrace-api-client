package util.http;

import util.http.model.MtraceHttpRequest;
import util.http.model.MtraceHttpResponse;

public interface MtraceHttpClient {
   MtraceHttpResponse get(MtraceHttpRequest request) throws Exception;
}
