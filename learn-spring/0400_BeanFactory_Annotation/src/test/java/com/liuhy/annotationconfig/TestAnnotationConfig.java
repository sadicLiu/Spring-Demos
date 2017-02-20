package com.liuhy.annotationconfig;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/18.
 */
public class TestAnnotationConfig
{
    @Test
    public void testConfig()
    {
        String xmlPath = "beans.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        UserAction userAction = (UserAction) applicationContext.getBean("userAction");
        /*UserAction userAction2 = (UserAction) applicationContext.getBean("userAction");
        System.out.println(userAction);
        System.out.println(userAction2);
        */
        userAction.execute();
        applicationContext.close();
    }
}
