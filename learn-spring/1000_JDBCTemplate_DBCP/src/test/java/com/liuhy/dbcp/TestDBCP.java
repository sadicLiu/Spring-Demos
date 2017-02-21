package com.liuhy.dbcp;

import com.liuhy.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/21.
 */
public class TestDBCP {
    @Test
    public void testDbcp() {
        User user = new User();
        user.setId(1);
        user.setUsername("lisi");
        user.setPassword("222");

        String path = "beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.update(user);
    }
}
