package com.liuhy.springproxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/19.
 */
public class TestSpringManualProxy {
    @Test
    public void testProxy() {
        String path = "beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        UserService proxyService = (UserService) applicationContext.getBean("proxyService");
        proxyService.addUser();
        proxyService.updateUser();
        proxyService.deleteUser();
    }
}
