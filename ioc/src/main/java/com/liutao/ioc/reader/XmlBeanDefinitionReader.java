package com.liutao.ioc.reader;

import com.liutao.ioc.BeanDefinition;
import com.liutao.ioc.PropertyValue;
import com.liutao.ioc.ResourceLoader;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.NodeList;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/9/18  10:52
 * @Modified By:
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    /**
     * 构造器，必须包含一个资源加载器
     *
     * @param resourceLoader 资源加载器
     */
    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void readerXML(String location) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(this.getClass().getClassLoader().getResourceAsStream(location
        ));
        registerBeanDefinitions(doc);
    }

    /**
     * 根据给定的文档对象进行解析，并注册到bean容器中
     *
     * @param doc 文档对象
     */
    private void registerBeanDefinitions(Document doc) {
        Element root = doc.getRootElement();
        parseBeanDefinitions(root);
    }

    /**
     * 解析元素的根节点及根节点下的所有子节点并添加进注册容器
     *
     * @param root XML 文件根节点
     */
    private void parseBeanDefinitions(Element root) {
        // 读取根元素的所有子元素
        List<Element> elements = root.elements();
        elements.stream().forEach(element -> processBeanDefinition(element));
    }

    /**
     * 解析给给定的节点，包括name，class，property， name， value，ref
     *
     * @param ele XML 解析元素
     */
    private void processBeanDefinition(Element ele) {
        String id = ele.attributeValue("id");
        String className = ele.attributeValue("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(className);
        // 向 bean 注入配置文件中的成员变量
        addPropertyValues(ele, beanDefinition);
        // 向注册容器 添加bean名称和bean定义
        getRegistry().put(id, beanDefinition);
        //拿到成员属性
        List<Element> sonSoneleme = ele.elements();
        Class<?> forName = null;
        try {
            Object obj = forName.newInstance();
            forName = Class.forName(className);
            for (Element element : sonSoneleme) {
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                //使用反射技术为私有属性赋值
                Field declaredField = null;
                try {
                    declaredField = forName.getDeclaredField(name);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                //运行往私有属性赋值
                declaredField.setAccessible(true);
                declaredField.set(obj, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 添加配置文件中的属性元素到bean定义实例中
     *
     * @param ele            元素
     * @param beandefinition bean定义 对象
     */
    private void addPropertyValues(Element ele, BeanDefinition beandefinition) {
        // 获取给定元素的 property 属性集合
        NodeList propertyNode = ele.getElementsByTagName("property");
        // 循环集合
        for (int i = 0; i < propertyNode.getLength(); i++) {
            // 获取集合中某个给定位置的节点
            Node node = propertyNode.item(i);
            // 类型判断
            if (node instanceof Element) {
                // 将节点向下强转为子元素
                Element propertyEle = (Element) node;
                // 元素对象获取 name 属性
                String name = propertyEle.getAttribute("name");
                // 元素对象获取 value 属性值
                String value = propertyEle.getAttribute("value");
                // 判断value不为空
                if (value != null && value.length() > 0) {
                    // 向给定的 “bean定义” 实例中添加该成员变量
                    beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    // 如果为空，则获取属性ref
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        // 如果属性ref为空，则抛出异常
                        throw new IllegalArgumentException(
                                "Configuration problem: <property> element for property '"
                                        + name + "' must specify a ref or value");
                    }
                    // 如果不为空，测创建一个 “bean的引用” 实例，构造参数为名称，实例暂时为空
                    BeanReference beanRef = new BeanReference(name);
                    // 向给定的 “bean定义” 中添加成员变量
                    beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanRef));
                }
            }
        }
    }
}
