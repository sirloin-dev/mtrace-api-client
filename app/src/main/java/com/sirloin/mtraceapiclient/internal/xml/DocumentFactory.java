package com.sirloin.mtraceapiclient.internal.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.annotation.Nonnull;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public final class DocumentFactory {
   /**
    * xml을 Document로 변환합니다.
    *
    * @param xmlInputStream Documnet로 변환할 InputStream
    * @return Document xml을 Documnet로 변환한 결과물
    */
   @Nonnull
   public Document parse(final @Nonnull InputStream xmlInputStream)
           throws ParserConfigurationException, IOException, SAXException {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
      factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
      factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
      factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
      factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
      factory.setExpandEntityReferences(false);
      return factory.newDocumentBuilder().parse(xmlInputStream);
   }
}
