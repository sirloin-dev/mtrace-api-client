package com.sirloin.mtraceapiclient.internal.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public interface ResponseXmlParserMixin {

    /**
     * node를 Element 타입으로 캐스팅합니다.
     * @param node Element로 변환할 node
     * @return Element로 변환된 node
     */
    default Element toElement(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            return (Element) node;
        } else {
            throw new IllegalArgumentException("해당 node는 Element가 아닙니다.");
        }
    }

    /**
     * nodelist의 첫번째 값의 text값을 가져옵니다.
     * @param nodeList 검색한 nodelist
     * @return 해당 노드의 TextContent
     */
    default String getText(NodeList nodeList) {
        return nodeList.item(0).getTextContent();
    }
}
