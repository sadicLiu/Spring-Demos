package com.liuhy.annotationconfig;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * Created by liuhy on 2017/2/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    private UserDao userDao;

    //    @Autowired
//    @Qualifier("userDao")
    @Resource(name = "userDao")
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public void addUser()
    {
        userDao.save();
    }

    @PostConstruct
    public void init()
    {
        System.out.println("init invoked!");
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("destroy invoked!");
    }

}
