package com.liutao.ioc.loader;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * @author: LIUTAO
 * @Date: Created in 2019/4/16  9:33
 * @Modified By:
 */
public class DefaultDocumentLoader implements DocumentLoader {


    @Override
    public Document loadDocument(InputSource inputSource) throws Exception {
        DocumentBuilderFactory factory = createDocumentBuilderFactory();
        DocumentBuilder builder = createDocumentBuilder(factory);
        return builder.parse(inputSource);
    }


    private DocumentBuilderFactory createDocumentBuilderFactory() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory;
    }

    private DocumentBuilder createDocumentBuilder(DocumentBuilderFactory factory) {
        DocumentBuilder documentBuilder = null;
        try {
             documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return documentBuilder;
    }
}
