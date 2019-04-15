package com.liutao.ioc.factory;

import com.liutao.ioc.BeanDefinition;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/9/18  11:47
 * @Modified By:
 */
public abstract class AbstractBeanFactory implements BeanFactory {


    //用于存放bean的定义数据
    private ConcurrentHashMap<String,BeanDefinition> map = new ConcurrentHashMap<>();

    /**
     * 根据Bean的名称从容器种获取Bean对象
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception{
        BeanDefinition beanDefinition = map.get(name);
        if(beanDefinition == null){
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }

        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreate(beanDefinition);
        }

        return bean;
    }

    /**
     * 注册Bean定义的抽象方法实现
     * 这里用到了模板方法设计模式，调用子类方法doCreate
     * @param name
     * @param beanDefinition
     * @throws Exception
     */
    @Override
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition) throws Exception{
        Object bean = doCreate(beanDefinition);
        beanDefinition.setBean(bean);
        map.put(name,beanDefinition);
    }

    /**
     * 创建一个Bean，将具体实现延迟到子类
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    abstract Object doCreate(BeanDefinition beanDefinition) throws Exception;
}
