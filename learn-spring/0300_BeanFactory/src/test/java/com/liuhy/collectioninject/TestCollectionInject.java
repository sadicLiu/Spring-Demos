package com.liuhy.collectioninject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/18.
 */
public class TestCollectionInject
{
    @Test
    public void testCollectionInject()
    {
        String xmlPath = "collection.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        CollectionData collectionData = (CollectionData) applicationContext.getBean("collectionData");
        System.out.println(collectionData.toString());
    }
}
