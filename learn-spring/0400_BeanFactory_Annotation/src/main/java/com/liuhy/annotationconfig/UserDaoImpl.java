package com.liuhy.annotationconfig;

import org.springframework.stereotype.Repository;

/**
 * Created by liuhy on 2017/2/18.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao
{
    @Override
    public void save()
    {
        System.out.println("user saved in userDao");
    }
}
