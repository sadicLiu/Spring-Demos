package com.liuhy.lifecycle;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/16.
 */
public class TestPostBeanProcessor
{
    @Test
    public void testInstanceFactoryAddUser()
    {
        String xmlPath = "postprocessorbeans.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();

        applicationContext.close();

    }
}
