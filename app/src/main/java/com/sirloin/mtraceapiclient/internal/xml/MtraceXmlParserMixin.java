package com.sirloin.mtraceapiclient.internal.xml;

import com.sirloin.mtraceapiclient.internal.http.exception.MtraceRequestException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public interface MtraceXmlParserMixin {

    /**
     * 응답받은 body가 정상적인 응답인지 아닌지 판별후 처리합니다.
     *
     * @param doc 응답받은 body를 변환한 Document
     */
    default void assertSuccess(final Document doc) {
        Element resultCode = getFirstElement("resultCode", doc);
        if (!resultCode.getTextContent().equals("00")) {
            throw new MtraceRequestException(
                    getFirstElement("resultMsg", doc).getTextContent(),
                    resultCode.getTextContent()
            );
        }
    }

    /**
     * node를 Element 타입으로 캐스팅합니다.
     *
     * @param node Element로 변환할 node
     * @return Element로 변환된 node
     */
    default Element asElement(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            return (Element) node;
        } else {
            throw new IllegalArgumentException("this node is not Element");
        }
    }

    /**
     * Document에서 tagname으로 첫번째 element를 조회하여 가져옵니다.
     *
     * @param tagName 검색할 tag의 name
     * @param doc     tagname으로 찾을 Document
     * @return 조회된 Element
     */
    @Nonnull
    default Element getFirstElement(final String tagName, final Document doc) {
        NodeList nodeList = doc.getElementsByTagName(tagName);
        if (nodeList.item(0) == null) {
            throw new IllegalStateException(tagName + " tag를 찾을수 없습니다");
        } else {
            return asElement(nodeList.item(0));
        }
    }

    /**
     * nodelist의 첫번째 값의 text값을 가져옵니다.
     *
     * @param nodeList 검색한 nodelist
     * @return 해당 노드의 TextContent
     */
    @Nonnull
    default String getText(final NodeList nodeList) {
        return nodeList.item(0).getTextContent();
    }

    /**
     * nodelist의 첫번째 값의 text값을 가져옵니다.
     * item(0)으로 조회후 값이없다면 null을 리턴합니다
     *
     * @param nodeList 검색한 nodelist
     * @return 해당 노드의 TextContent or null
     */
    @Nullable
    default String getTextOrNull(final NodeList nodeList) {
        Node node = nodeList.item(0);
        return node != null ? node.getTextContent() : null;
    }

    /**
     * @return kst 시간으로 ZoneOffset을 설정합니다.
     */
    default ZoneId kst() {
        return ZoneId.of("Asia/Seoul");
    }

    /**
     * ymd형식의 노드를 Instant로 변환합니다.
     *
     * @param nodeList 변환할 데이터
     * @return kst -> utc instant
     */
    default ZonedDateTime ymdToKstZonedDateTime(final NodeList nodeList) {
        final String value = getTextOrNull(nodeList);
        if (Objects.isNull(value)) {
            return null;
        } else {
            final String ymdPattern = "yyyyMMdd";
            return LocalDate.parse(value, DateTimeFormatter.ofPattern(ymdPattern))
                    .atStartOfDay()
                    .atZone(kst());
        }

    }

    /**
     * date 형식의 노드를 Instant로 변환합니다.
     *
     * @param nodeList 변환할 데이터
     * @return kst -> utc instant
     */
    default ZonedDateTime dateKstToInstant(final NodeList nodeList) {
        final String value = getTextOrNull(nodeList);
        if (Objects.isNull(value)) {
            return null;
        } else {
            return LocalDate.parse(value)
                    .atStartOfDay()
                    .atZone(kst());
        }
    }

}
