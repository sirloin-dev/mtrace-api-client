package com.sirloin.mtraceapiclient.api.grade.confirm;

import com.sirloin.mtraceapiclient.api.grade.confirm.model.GradeConfirmInformation;
import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpRequest;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpResponse;
import com.sirloin.mtraceapiclient.internal.xml.DocumentFactory;
import com.sirloin.mtraceapiclient.internal.xml.MtraceXmlParserMixin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * 축산물 등급판정확인서 인터페이스 구현체입니다.
 */
final class GradeConfirmImpl implements GradeConfirm, MtraceXmlParserMixin {
    /**
     * Mtrace api용 httpclient 입니다.
     */
    @SuppressWarnings("PMD.BeanMembersShouldSerialize")
    private final MtraceHttpClient httpClient;

    /**
     * api 이용에 필요한 인증키입니다.
     */
    @SuppressWarnings("PMD.BeanMembersShouldSerialize")
    private final String serviceKey;

    /**
     * 축산물 등급판정확인서 url입니다.
     */
    private static final String GRADE_CONFIRM_URL = "http://data.ekape.or.kr/openapi-data/service/user/grade/confirm/issueNo";

    /**
     * 축산물 등급판정확인서 인터페이스 구현체 생성자.
     *
     * @param httpClient Mtrace api용 httpclient 입니다.
     * @param serviceKey : 공공데이터포털에서 받은 인증키입니다 decoding된 key를 입력하여주세요 required
     */
    GradeConfirmImpl(final MtraceHttpClient httpClient, final String serviceKey) {
        this.httpClient = httpClient;
        this.serviceKey = serviceKey;
    }

    @Override
    public GradeConfirmInformation gradeConfirm(
            final String animalNo
    ) throws IOException, ParserConfigurationException, SAXException {
        Map<String, Object> params = new HashMap<>();
        params.put("animalNo", animalNo);
        params.put("serviceKey", serviceKey);

        MtraceHttpResponse response = httpClient.get(
                new MtraceHttpRequest(
                        GRADE_CONFIRM_URL,
                        params
                )
        );

        return responseConvert(response);
    }

    private GradeConfirmInformation responseConvert(final MtraceHttpResponse response)
            throws ParserConfigurationException, IOException, SAXException {
        Document doc = new DocumentFactory().parse(response.body());
        assertSuccess(doc);
        Element item = getFirstElement("item", doc);
        return new GradeConfirmInformation(
                getText(item.getElementsByTagName("animalNo")),
                getText(item.getElementsByTagName("judgeKindCd")),
                getText(item.getElementsByTagName("judgeKindNm")),
                getText(item.getElementsByTagName("abattCode")),
                getText(item.getElementsByTagName("abattNm")),
                LocalDate.parse(getText(item.getElementsByTagName("abattDate")))
                        .atStartOfDay().toInstant(ZoneOffset.UTC),
                LocalDate.parse(getText(item.getElementsByTagName("judgeDate"))).
                        atStartOfDay().toInstant(ZoneOffset.UTC),
                LocalDate.parse(getText(item.getElementsByTagName("issueDate")))
                        .atStartOfDay().toInstant(ZoneOffset.UTC),
                getText(item.getElementsByTagName("issueNo"))
        );
    }
}
