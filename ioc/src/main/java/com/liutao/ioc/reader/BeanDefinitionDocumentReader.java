package com.liutao.ioc.reader;

import org.w3c.dom.Document;

/**
 * Parsing an XML document that contains Spring bean definitions
 *
 * @author: LIUTAO
 * @Date: Created in 2019/4/16  9:45
 * @Modified By:
 */
public interface BeanDefinitionDocumentReader {

      void registerBeanDefinitions(Document document,XmlReaderContext readerContext);
}
