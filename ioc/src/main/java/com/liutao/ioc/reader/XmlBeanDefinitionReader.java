package com.liutao.ioc.reader;

import com.liutao.ioc.resource.Resource;
import com.liutao.ioc.support.BeanDefinitionRegistry;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.InputStream;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/9/18  10:52
 * @Modified By:
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    /**
     * 构造器，必须包含一个资源加载器
     *
     * @param registry 资源加载器
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public int loadBeanDefinitions(Resource resource) throws Exception {
        InputStream inputStream = resource.getInputStream();
        InputSource inputSource = new InputSource(inputStream);
        //TODO 转换成Document
        Document document = doLoadDocument(inputSource,resource);
        return 0;
    }

    private Document doLoadDocument(InputSource inputSource, Resource resource) {

        return null;
    }


}
