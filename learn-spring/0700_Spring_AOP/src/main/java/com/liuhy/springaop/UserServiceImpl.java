package com.liuhy.springaop;

/**
 * Created by liuhy on 2017/2/19.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("User added");
    }

    @Override
    public void updateUser() {
        System.out.println("User updated");
    }

    @Override
    public void deleteUser() {
        System.out.println("User deleted");
    }
}
