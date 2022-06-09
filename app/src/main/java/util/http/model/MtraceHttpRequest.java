package util.http.model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public record MtraceHttpRequest(
        String url,
        Map<String, Object> queryParameters
) {
   @Override
   public String url() {
      if (this.queryParameters.isEmpty()) {
         return this.url;
      } else {
         StringBuilder result = new StringBuilder(this.url).append("?");

         for (Map.Entry<String, Object> param : this.queryParameters.entrySet()) {
            result.append(param.getKey()).append('=').append(URLEncoder.encode(param.getValue().toString(), StandardCharsets.UTF_8)).append('&');
         }

         return result.substring(0, result.length() - 1);
      }
   }

}