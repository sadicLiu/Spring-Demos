package com.liuhy.cglibproxy;

import org.junit.Test;

/**
 * Created by liuhy on 2017/2/19.
 */
public class TestCglibProxy {

    @Test
    public void testProxy() {
        UserService userService = MyBeanFactory.createUserService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
