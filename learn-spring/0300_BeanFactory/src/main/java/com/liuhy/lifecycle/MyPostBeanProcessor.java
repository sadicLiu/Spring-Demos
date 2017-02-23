package com.liuhy.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * Created by liuhy on 2017/2/18.
 */
public class MyPostBeanProcessor implements BeanPostProcessor
{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("postProcessBeforeInitialization: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("postProcessAfterInitialization: " + beanName);
        return Proxy.newProxyInstance(MyPostBeanProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) ->
        {
            System.out.println("***proxy before method invoke***");
            Object object = method.invoke(bean, args);
            System.out.println("***proxy after method invoke***");
            return object;
        });
    }
}
