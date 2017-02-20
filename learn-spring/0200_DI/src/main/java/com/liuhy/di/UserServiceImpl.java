package com.liuhy.di;

/**
 * Created by liuhy on 2017/2/17.
 */
public class UserServiceImpl implements UserService
{
    private UserDao userDao;

    public void addUser()
    {
        userDao.save();
    }

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }
}
