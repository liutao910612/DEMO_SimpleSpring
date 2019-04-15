package com.liutao.ioc.factory;

import com.liutao.ioc.BeanDefinition;
import com.liutao.ioc.support.BeanDefinitionRegistry;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: LIUTAO
 * @Date: Created in 2019/4/15  11:31
 * @Modified By:
 */
public class DefaultListableBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {

    private final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    private volatile Set<String> beanDefinitionNames = new HashSet<>(256);

    @Override
    Object doCreate(BeanDefinition beanDefinition) throws Exception {
        return null;
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return null;
    }
}
