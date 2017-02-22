package com.liuhy.hikari;

import com.liuhy.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by liuhy on 2017/2/22.
 */
public class TestHikari {

    @Test
    public void testHikari() {
        String path = "hikari.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        User user = new User();
        user.setUsername("jack");
        user.setPassword("rose");
        userDao.addUser(user);
    }

    @Test
    public void testQueryAll() {
        String path = "hikari.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
