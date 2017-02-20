package com.liuhy.setterinject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/18.
 */
public class TestSetterInject
{
    @Test
    public void testConstructorInject()
    {
        String xmlPath = "setterinject.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.toString());
    }
}
