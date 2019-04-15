package com.liutao.ioc.support;

import com.liutao.ioc.BeanDefinition;

/**
 * @author: LIUTAO
 * @Date: Created in 2019/4/15  11:36
 * @Modified By:
 */
public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanName);
}
