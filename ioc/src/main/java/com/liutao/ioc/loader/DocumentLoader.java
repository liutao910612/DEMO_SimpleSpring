package com.liutao.ioc.loader;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * @author: LIUTAO
 * @Date: Created in 2019/4/16  9:30
 * @Modified By:
 */
public interface DocumentLoader {

    Document loadDocument(
            InputSource inputSource)
            throws Exception;
}
