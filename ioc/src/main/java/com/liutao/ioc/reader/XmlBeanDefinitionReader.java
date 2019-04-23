package com.liutao.ioc.reader;

import com.liutao.ioc.loader.DefaultDocumentLoader;
import com.liutao.ioc.loader.DocumentLoader;
import com.liutao.ioc.resource.Resource;
import com.liutao.ioc.support.BeanDefinitionRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.io.InputStream;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/9/18  10:52
 * @Modified By:
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    private DocumentLoader documentLoader = new DefaultDocumentLoader();

    /**
     * 构造器，必须包含一个资源加载器
     *
     * @param registry 资源加载器
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * load bean definitions from the specified XML file
     *
     * note：Simple Spring use Resource replace EncodedResource
     * @param resource
     * @return
     * @throws Exception
     */
    public int loadBeanDefinitions(Resource resource) throws Exception {
        InputStream inputStream = resource.getInputStream();
        InputSource inputSource = new InputSource(inputStream);
        Document document = doLoadDocument(inputSource);
        int count = registerBeanDefinitions(document,resource);
        return count;
    }

    /**
     * Register the bean definitions contained in the given DOM document
     * @param document
     * @param resource
     * @return
     */
    public int registerBeanDefinitions(Document document, Resource resource) {

        Element root = document.getDocumentElement();
        return 0;
    }

    /**
     * load the specified document using the configured DocumentLoader
     * @param inputSource
     * @return
     */
    public Document doLoadDocument(InputSource inputSource) {
        try {
            return this.documentLoader.loadDocument(inputSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




}
