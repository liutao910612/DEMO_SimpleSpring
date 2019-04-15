package com.liutao.ioc.factory;

import com.liutao.ioc.BeanDefinition;

/**
 * 需要一个BeanFactory定义IOC容器的一些行为
 * 比如根据名称获取Bean、注册Bean，参数为Bean的名称、Bean的定义
 *
 * @author: LIUTAO
 * @Date: Created in 2018/9/10  14:19
 * @Modified By:
 */
public interface BeanFactory {

    /**
     * 根据Bean的名称从容器种获取Bean对象
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;

    /**
     * 将Bean注册到容器中
     * @param name
     * @param bean
     * @throws Exception
     */
    void registerBeanDefinition(String name, BeanDefinition bean) throws Exception;
}
