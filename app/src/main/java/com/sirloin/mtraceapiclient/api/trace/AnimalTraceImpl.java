package com.sirloin.mtraceapiclient.api.trace;


import com.sirloin.mtraceapiclient.api.trace.model.TraceResult;
import com.sirloin.mtraceapiclient.api.trace.model.AnimalInformation;
import com.sirloin.mtraceapiclient.api.trace.model.ButcheryInformation;
import com.sirloin.mtraceapiclient.api.trace.model.FarmInformation;
import com.sirloin.mtraceapiclient.api.trace.model.InjectionInformation;
import com.sirloin.mtraceapiclient.api.trace.model.InspectInformation;
import com.sirloin.mtraceapiclient.api.trace.model.ProcessPlaceInformation;
import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpRequest;
import com.sirloin.mtraceapiclient.internal.http.model.MtraceHttpResponse;
import com.sirloin.mtraceapiclient.internal.xml.DocumentFactory;
import com.sirloin.mtraceapiclient.internal.xml.ResponseXmlParserMixin;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.annotation.Nullable;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * 통합 이력조회 서비스 인터페이스 구현체입니다.
 */
public final class AnimalTraceImpl implements AnimalTrace, ResponseXmlParserMixin {

    /**
     * 통합 이력조회 URL 입니다.
     */
    private static final String TRACE_NO_SEARCH_URL
            = "http://data.ekape.or.kr/openapi-data/service/user/animalTrace/traceNoSearch";

    /**
     * 통합 이력조회 서비스의 YMD 필드들의 data 패턴입니다.
     */
    private static final String YMD_PATTERN = "yyyyMMdd";
    /**
     * 이력번호 parameter name입니다.
     */
    private static final String TRACE_NO = "traceNo";
    /**
     * 인증키 parameter name입니다.
     */
    private static final String SERVICE_KEY = "serviceKey";
    /**
     * 조회정보 xml tag name입니다.
     */
    private static final String INFO_TYPE = "infoType";
    /**
     * 소/돼지/묶음 구분 xml tag name입니다.
     */
    private static final String TRACE_NO_TYPE = "traceNoType";

    /**
     * MtraceHttpClient 입니다.
     */
    @SuppressWarnings("PMD.BeanMembersShouldSerialize")
    private final MtraceHttpClient httpClient;

    AnimalTraceImpl(final MtraceHttpClient mtraceHttpClient) {
        this.httpClient = mtraceHttpClient;
    }

    @Override
    public TraceResult traceNoSearch(final String traceNo, final String serviceKey) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put(TRACE_NO, traceNo);
        params.put(SERVICE_KEY, serviceKey);

        MtraceHttpResponse response = httpClient.get(
                new MtraceHttpRequest(
                        TRACE_NO_SEARCH_URL,
                        params
                )
        );
        return responseConvert(response);
    }

    @Override
    public TraceResult traceNoSearch(
            final String traceNo,
            final String serviceKey,
            final int optionNo
    ) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put(TRACE_NO, traceNo);
        params.put(SERVICE_KEY, serviceKey);
        params.put("optionNo", optionNo);


        MtraceHttpResponse response = httpClient.get(
                new MtraceHttpRequest(
                        TRACE_NO_SEARCH_URL,
                        params
                )
        );
        return responseConvert(response);
    }

    @Override
    public TraceResult traceNoSearch(
            final String traceNo,
            final String serviceKey,
            final int optionNo,
            final String corpNo
    ) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put(TRACE_NO, traceNo);
        params.put(SERVICE_KEY, serviceKey);
        params.put("optionNo", optionNo);
        params.put("corpNo", corpNo);

        MtraceHttpResponse response = httpClient.get(
                new MtraceHttpRequest(
                        TRACE_NO_SEARCH_URL,
                        params
                )
        );
        return responseConvert(response);
    }

    private TraceResult responseConvert(final MtraceHttpResponse response)
            throws ParserConfigurationException, IOException, SAXException {

        NodeList items = new DocumentFactory().parse(response.body()).getElementsByTagName("item");
        Map<Integer, List<Element>> mappedByInfoType = new HashMap<>();
        mapToElements(items).forEach(item -> {
            int key = Integer.parseInt(getText(item.getElementsByTagName(INFO_TYPE)));
            if (mappedByInfoType.containsKey(key)) {
                mappedByInfoType.get(key).add(item);
            } else {
                List<Element> value = new ArrayList<>();
                value.add(item);
                mappedByInfoType.put(key, value);
            }
        });

        return new TraceResult(
                toAnimalInformation(mappedByInfoType.get(InfoTypeNum.ANIMAL_INFO.value)),
                toFarmInformationList(mappedByInfoType.get(InfoTypeNum.FARM_INFO.value)),
                toButcheryInformation(mappedByInfoType.get(InfoTypeNum.BUTCHERY_INFO.value)),
                toProcessPlaceInformation(mappedByInfoType.get(InfoTypeNum.PROCESS_PLACE_INFO.value)),
                toInjectionInformation(mappedByInfoType.get(InfoTypeNum.INJECTION_INFO.value)),
                toInspectInformation(mappedByInfoType.get(InfoTypeNum.INSPECT_INFO.value))
        );
    }

    private List<Element> mapToElements(final NodeList nodeList) {
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); ++i) {
            elements.add(toElement((nodeList.item(i))));
        }
        return elements;
    }


    private static String getAnimalNo(final NodeList nodeList) {
        Node node = nodeList.item(0);
        return node != null ? node.getTextContent() : null;
    }

    private static Instant ymdToInstant(final String ymdText) {
        return LocalDate.parse(ymdText, DateTimeFormatter.ofPattern(YMD_PATTERN))
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC);
    }

    private AnimalInformation toAnimalInformation(final List<Element> elements) {
        if (Objects.isNull(elements) || elements.isEmpty()) {
            return null;
        }
        Element element = elements.stream().findFirst().orElseThrow();
        return new AnimalInformation(
                ymdToInstant(getText(element.getElementsByTagName("birthYmd"))),
                getAnimalNo(element.getElementsByTagName("cattleNo")),
                getAnimalNo(element.getElementsByTagName("pigNo")),
                getText(element.getElementsByTagName("farmNo")),
                getText(element.getElementsByTagName("farmUniqueNo")),
                Integer.parseInt(getText(element.getElementsByTagName(INFO_TYPE))),
                getText(element.getElementsByTagName("lsTypeNm")),
                Integer.parseInt(getText(element.getElementsByTagName("monthDiff"))),
                getText(element.getElementsByTagName("sexNm")),
                getText(element.getElementsByTagName(TRACE_NO_TYPE))
        );
    }

    private List<FarmInformation> toFarmInformationList(final List<Element> elements) {
        if (Objects.isNull(elements) || elements.isEmpty()) {
            return new ArrayList<>();
        }

        return elements.stream().map(element -> new FarmInformation(
                getText(element.getElementsByTagName("farmAddr")),
                getText(element.getElementsByTagName("farmNo")),
                getText(element.getElementsByTagName("farmerNm")),
                Integer.parseInt(getText(element.getElementsByTagName(INFO_TYPE))),
                getText(element.getElementsByTagName("regType")),
                ymdToInstant(getText(element.getElementsByTagName("regYmd"))),
                getText(element.getElementsByTagName(TRACE_NO_TYPE))
        )).toList();
    }

    private ButcheryInformation toButcheryInformation(@Nullable final List<Element> elements) {
        if (Objects.isNull(elements) || elements.isEmpty()) {
            return null;
        }
        Element element = elements.stream().findFirst().orElseThrow();
        return new ButcheryInformation(
                getText(element.getElementsByTagName("butcheryPlaceAddr")),
                getText(element.getElementsByTagName("butcheryPlaceNm")),
                ymdToInstant(getText(element.getElementsByTagName("butcheryYmd"))),
                getText(element.getElementsByTagName("gradeNm")),
                Integer.parseInt(getText(element.getElementsByTagName(INFO_TYPE))),
                getText(element.getElementsByTagName("inspectPassYn")),
                getText(element.getElementsByTagName(TRACE_NO_TYPE))
        );
    }

    private ProcessPlaceInformation toProcessPlaceInformation(@Nullable final List<Element> elements) {
        if (Objects.isNull(elements) || elements.isEmpty()) {
            return null;
        }
        Element element = elements.stream().findFirst().orElseThrow();
        return new ProcessPlaceInformation(
                getText(element.getElementsByTagName("processPlaceAddr")),
                getText(element.getElementsByTagName("processPlaceNm")),
                Integer.parseInt(getText(element.getElementsByTagName(INFO_TYPE))),
                getText(element.getElementsByTagName(TRACE_NO_TYPE))
        );
    }

    private InjectionInformation toInjectionInformation(@Nullable final List<Element> elements) {
        if (Objects.isNull(elements) || elements.isEmpty()) {
            return null;
        }
        Element element = elements.stream().findFirst().orElseThrow();
        return new InjectionInformation(
                ymdToInstant(getText(element.getElementsByTagName("injectionYmd"))),
                getText(element.getElementsByTagName("injectiondayCnt")),
                getText(element.getElementsByTagName("vaccineorder")),
                Integer.parseInt(getText(element.getElementsByTagName(INFO_TYPE))),
                getText(element.getElementsByTagName(TRACE_NO_TYPE))
        );
    }

    private InspectInformation toInspectInformation(@Nullable final List<Element> elements) {
        if (Objects.isNull(elements) || elements.isEmpty()) {
            return null;
        }
        Element element = elements.stream().findFirst().orElseThrow();
        return new InspectInformation(
                ymdToInstant(getText(element.getElementsByTagName("inspectDt"))),
                getText(element.getElementsByTagName("inspectYn")),
                Integer.parseInt(getText(element.getElementsByTagName(INFO_TYPE))),
                getText(element.getElementsByTagName(TRACE_NO_TYPE))
        );
    }

    /**
     * 옵션정보 enum입니다.
     */
    private enum InfoTypeNum {

        /**
         * 조회한 동물의 개체의 정보.
         */
        ANIMAL_INFO(1),
        /**
         * 도축장 정보.
         */
        FARM_INFO(2),
        /**
         * 출생 등 신고정보.
         */
        BUTCHERY_INFO(3),
        /**
         * 포장처리 정보.
         */
        PROCESS_PLACE_INFO(4),
        /**
         * 백신접종 정보.
         */
        INJECTION_INFO(5),
        /**
         * 가축질병 검사 정보.
         */
        INSPECT_INFO(7);

        InfoTypeNum(final int val) {
            this.value = val;
        }

        /**
         * 해당 타입의 옵션 number입니다.
         */
        private final int value;

    }
}
