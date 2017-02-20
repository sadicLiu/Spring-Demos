package com.liuhy.jdkproxy;

import org.junit.Test;

/**
 * Created by liuhy on 2017/2/19.
 */
public class TestJDKProxy {

    @Test
    public void testProxy() {
        UserService userService = MyBeanFactory.createUserService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
