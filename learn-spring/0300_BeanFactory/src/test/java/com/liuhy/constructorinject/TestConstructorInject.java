package com.liuhy.constructorinject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/18.
 */
public class TestConstructorInject
{
    @Test
    public void testConstructorInject()
    {
        String xmlPath = "constructorinject.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        User user = (User) applicationContext.getBean("user");
        System.out.println(user.toString());
    }
}
