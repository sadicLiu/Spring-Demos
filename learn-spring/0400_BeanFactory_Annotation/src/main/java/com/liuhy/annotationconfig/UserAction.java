package com.liuhy.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by liuhy on 2017/2/18.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction
{
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    public String execute()
    {
        userService.addUser();
        return "success";
    }
}
