package com.liuhy.staticfactory;

/**
 * Created by liuhy on 2017/2/17.
 */
public class MyBeanFactory
{
    public static UserService createUserService()
    {
        return new UserServiceImpl();
    }
}
