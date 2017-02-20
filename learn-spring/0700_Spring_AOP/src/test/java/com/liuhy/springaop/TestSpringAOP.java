package com.liuhy.springaop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/19.
 */
public class TestSpringAOP {
    @Test
    public void testAOP() {
        String path = "beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
