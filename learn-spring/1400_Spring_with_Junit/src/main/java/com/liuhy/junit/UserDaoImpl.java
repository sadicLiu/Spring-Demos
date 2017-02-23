package com.liuhy.junit;

import org.springframework.stereotype.Repository;

/**
 * Created by liuhy on 2017/2/17.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("a user saved!");
    }
}
