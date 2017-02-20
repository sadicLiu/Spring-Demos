package com.liuhy.lifecycle;

/**
 * Created by liuhy on 2017/2/17.
 */
public class UserServiceImpl implements UserService
{

    public void addUser()
    {
        System.out.println("a user added!");
    }

    public void init ()
    {
        System.out.println("init invoked!");
    }

    public void destroy()
    {
        System.out.println("destroy invoked!");
    }
}
