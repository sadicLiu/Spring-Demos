package com.liuhy.instancefactory;

/**
 * Created by liuhy on 2017/2/17.
 */
public class MyBeanFactory
{
    public UserService createUserService()
    {
        return new UserServiceImpl();
    }
}
