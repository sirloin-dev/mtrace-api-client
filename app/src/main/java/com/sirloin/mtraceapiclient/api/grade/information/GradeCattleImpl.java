package com.sirloin.mtraceapiclient.api.grade.information;

import com.sirloin.mtraceapiclient.api.grade.information.model.CattleGradeInformation;
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
 * 소 등급판정정보 확인 api 구현체입니다.
 */
final class GradeCattleImpl implements Grade<CattleGradeInformation>, MtraceXmlParserMixin {

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
     * 소 등급 판정정보 Url입니다.
     */
    private static final String GRADE_CATTLE_URL =
            "http://data.ekape.or.kr/openapi-data/service/user/grade/confirm/cattle";

    GradeCattleImpl(final MtraceHttpClient httpClient, final String serviceKey) {
        this.httpClient = httpClient;
        this.serviceKey = serviceKey;
    }

    /**
     * 소개체의 등급판정 정보를 가져옵니다.
     *
     * @param issueNo      확인서 번호
     * @param issueDateStr 확인서 발급일 String 형태 yyyy-mm-dd 형식의 String 이어야 한다.
     * @return CattleGradeInformation
     */
    @Override
    public CattleGradeInformation grade(
            final String issueNo,
            final String issueDateStr
    ) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("issueNo", issueNo);
        params.put("issueDate", issueDateStr);
        params.put("serviceKey", serviceKey);

        MtraceHttpResponse response = httpClient.get(
                new MtraceHttpRequest(GRADE_CATTLE_URL, params)
        );
        return responseConvert(response);
    }

    /**
     * https://www.data.go.kr/data/15058822/openapi.do 의 소 등급판정결과(확인서)정보.
     * 해당 api에서 항목구분이 필수로 구분되어있지만 응답이 안오는 경우를 발견해 해당 필드값은 nullable하게 작성하였습니다.
     *
     * @param response convert할 응답객체
     * @return CattleGradeInformation
     */
    private CattleGradeInformation responseConvert(final MtraceHttpResponse response)
            throws ParserConfigurationException, IOException, SAXException {
        Document doc = new DocumentFactory().parse(response.body());
        assertSuccess(doc);
        Element item = getFirstElement("item", doc);
        return new CattleGradeInformation(
                LocalDate.parse(getText(item.getElementsByTagName("issueDate")))
                        .atStartOfDay().toInstant(ZoneOffset.UTC),
                getText(item.getElementsByTagName("issueNo")),
                getText(item.getElementsByTagName("judgeKindCd")),
                getText(item.getElementsByTagName("raterCode")),
                getText(item.getElementsByTagName("raterNm")),
                LocalDate.parse(getText(item.getElementsByTagName("abattDate")))
                        .atStartOfDay().toInstant(ZoneOffset.UTC),
                getTextOrNull(item.getElementsByTagName("abattNm")),
                LocalDate.parse(getText(item.getElementsByTagName("judgeDate")))
                        .atStartOfDay().toInstant(ZoneOffset.UTC),
                getTextOrNull(item.getElementsByTagName("abattCode")),
                getTextOrNull(item.getElementsByTagName("abattAddr")),
                getTextOrNull(item.getElementsByTagName("abattTelNo")),
                getTextOrNull(item.getElementsByTagName("reqUserNm")),
                getTextOrNull(item.getElementsByTagName("reqRegNo")),
                getTextOrNull(item.getElementsByTagName("reqComNm")),
                getTextOrNull(item.getElementsByTagName("reqAddr")),
                getTextOrNull(item.getElementsByTagName("reqTelNo")),
                getTextOrNull(item.getElementsByTagName("liveStockNm")),
                getTextOrNull(item.getElementsByTagName("abattFno")),
                getTextOrNull(item.getElementsByTagName("abattTno")),
                getText(item.getElementsByTagName("judgeBreedNm")),
                getText(item.getElementsByTagName("judgeSexNm")),
                getText(item.getElementsByTagName("weight")),
                getText(item.getElementsByTagName("gradeCd")),
                getText(item.getElementsByTagName("gradeNm")),
                getText(item.getElementsByTagName("costAmt")),
                getText(item.getElementsByTagName("windex")),
                getText(item.getElementsByTagName("qgrade")),
                getText(item.getElementsByTagName("wgrade")),
                Integer.parseInt(getText(item.getElementsByTagName("issueCnt"))),
                getText(item.getElementsByTagName("cattleNo")),
                getText(item.getElementsByTagName("backfat")),
                getText(item.getElementsByTagName("rea")),
                getText(item.getElementsByTagName("yuksak")),
                getText(item.getElementsByTagName("fatsak")),
                getText(item.getElementsByTagName("growth")),
                getText(item.getElementsByTagName("tissue")),
                getText(item.getElementsByTagName("insfat")),
                getTextOrNull(item.getElementsByTagName("birthMonth"))
        );
    }
}
