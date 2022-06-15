package com.sirloin.mtraceapiclient.api.trace;

import com.sirloin.mtraceapiclient.api.trace.model.TraceResult;
import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


/**
 * 축산물 통합 이력제 interface입니다.
 * 자세한 사용법은 https://www.data.go.kr/data/15058923/openapi.do 참고하여주세요.
 */
public interface AnimalTrace {
    /**
     * 축산물 이력정보 조회입니다.
     *
     * @param traceNo : 개체/이력/묶음 번호입니다 required
     * @return TraceResult 통합이력 조회 결과입니다
     */
    TraceResult traceNoSearch(
            String traceNo
    ) throws ParserConfigurationException, IOException, SAXException;

    /**
     * 축산물 이력정보 조회입니다.
     *
     * @param traceNo  : 개체/이력/묶음 번호입니다 required
     * @param optionNo : 옵션 번호입니다
     * @return TraceResult 통합이력 조회 결과입니다 조회한 옵션값을 제외한 나머지 값은 Null로 리턴됩니다.
     */
    TraceResult traceNoSearch(
            String traceNo,
            int optionNo
    ) throws ParserConfigurationException, IOException, SAXException;

    /**
     * 축산물 이력정보 조회입니다.
     *
     * @param traceNo  : 개체/이력/묶음 번호입니다 required
     * @param optionNo : 옵션 번호입니다
     * @param corpNo   : 사업자 번호입니다
     * @return TraceResult 통합이력 조회 결과입니다 조회한 옵션값을 제외한 나머지 값은 Null로 리턴됩니다.
     */
    TraceResult traceNoSearch(
            String traceNo,
            int optionNo,
            String corpNo
    ) throws ParserConfigurationException, IOException, SAXException;

    /**
     * AnimalTrace의 기본 구현체 생성 메서드입니다.
     *
     * @param serviceKey : 공공데이터포털에서 받은 인증키입니다 decoding된 key를 입력하여주세요 required
     * @return AnimalTraceImpl
     */
    static AnimalTrace newInstance(String serviceKey) {
        return new AnimalTraceImpl(MtraceHttpClient.newInstance(), serviceKey);
    }
}
