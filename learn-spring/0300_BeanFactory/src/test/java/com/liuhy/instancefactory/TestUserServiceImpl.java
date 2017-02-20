package com.liuhy.instancefactory;/* 测试第一个方法用这个类*/
//import com.liuhy.staticfactory.UserService;

import com.liuhy.instancefactory.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/16.
 */
public class TestUserServiceImpl
{
    @Test
    public void testStaticFactoryAddUser()
    {
        String xmlPath = "staticFactoryBeans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();
    }

    @Test
    public void testInstanceFactoryAddUser()
    {
        String xmlPath = "instanceFactoryBeans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();
    }
}
