package com.liutao.ioc.reader;


import com.liutao.ioc.BeanDefinition;
import com.liutao.ioc.loader.ResourceLoader;
import com.liutao.ioc.support.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/9/10  15:08
 * @Modified By:
 */
public class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 注册bean容器
     */
    private Map<String, BeanDefinition> registry;

    /**
     * 资源加载器
     */
    private BeanDefinitionRegistry beanDefinitionRegistry;

    /**
     * 构造器器必须有一个资源加载器， 默认插件创建一个map容器
     *
     * @param beanDefinitionRegistry 资源加载器
     */
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.registry = new HashMap<>();
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    /**
     * 获取容器
     */
    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }
}
