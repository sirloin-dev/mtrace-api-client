package com.sirloin.mtraceapiclient.internal.http.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;


/**
 * 해당 프로젝트 전용 request 객체입니다.
 */
public class MtraceHttpRequest {

    /**
     * Http 요청을 할 url.
     */
    private final String url;

    /**
     * Http요청시 보낼 parameter.
     *
     * 외부에 접근을 노출할 이유가 없어 해당 경고를 무시합니다.
     */
    @SuppressWarnings("PMD.BeanMembersShouldSerialize")
    private final Map<String, Object> queryParameters;

    /**
     * 기본 생성자입니다.
     *
     * @param url Http 요청을 할 url 주소입니다.
     * @param queryParameters Http요청시 보낼 parameter입니다.
     */
    public MtraceHttpRequest(final String url, final Map<String, Object> queryParameters) {
        this.url = url;
        this.queryParameters = queryParameters;
    }

    /**
     * queryParameters가 없다면 기본 url을 리턴하고 queryParameters의 K,V를 K=V로 붙혀 url를 리턴합니다.
     * 변환 과정중 V를 utf-8로 인코딩합니다.
     *
     * @return url 주소
     */
    public String getUrl() throws UnsupportedEncodingException {
        if (this.queryParameters.isEmpty()) {
            return this.url;
        } else {
            StringBuilder result = new StringBuilder(this.url).append("?");

            for (Map.Entry<String, Object> param : this.queryParameters.entrySet()) {
                result.append(param.getKey())
                        .append('=')
                        .append(URLEncoder.encode(param.getValue().toString(), "UTF-8"))
                        .append('&');
            }

            return result.substring(0, result.length() - 1);
        }
    }

}
