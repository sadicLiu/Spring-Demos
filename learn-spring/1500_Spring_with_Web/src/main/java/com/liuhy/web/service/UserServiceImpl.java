package com.liuhy.web.service;

import com.liuhy.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by liuhy on 2017/2/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser() {
        userDao.save();
    }

}
