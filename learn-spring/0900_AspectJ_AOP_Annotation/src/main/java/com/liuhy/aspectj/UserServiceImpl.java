package com.liuhy.aspectj;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("addUser");
    }

    @Override
    public String updateUser() {
        System.out.println("updateUser");
        // int i = 1 / 0;
        return "阳志就是屌";
    }

    @Override
    public void deleteUser() {

        System.out.println("deleteUser");
    }
}
