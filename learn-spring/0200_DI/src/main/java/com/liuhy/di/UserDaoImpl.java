package com.liuhy.di;

/**
 * Created by liuhy on 2017/2/17.
 */
public class UserDaoImpl implements UserDao
{
    @Override
    public void save()
    {
        System.out.println("a user saved!");
    }
}
