package com.liuhy.service;

import com.liuhy.dao.AccountDao;

/**
 * Created by liuhy on 2017/2/22.
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String from, String to, int money) {

    }
}
