package com.liuhy.c3p0;

import com.liuhy.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/21.
 */
public class TestC3P0 {
    @Test
    public void testDbcp() {
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("111");

        String path = "c3p0.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.update(user);
    }
}
