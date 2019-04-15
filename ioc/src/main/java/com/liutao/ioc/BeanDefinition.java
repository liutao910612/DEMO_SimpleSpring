package com.liutao.ioc;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/9/10  14:59
 * @Modified By:
 */
public class BeanDefinition {

    /**
     * bean
     */
    private Object bean;

    /**
     * bean的class对象
     */
    private Class beanClass;

    /**
     * bean的类全限定名
     */
    private String className;

    /**
     * 类的属性集合
     */
    private PropertyValue propertyValues = new PropertyValue();

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
        try {
            this.beanClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
