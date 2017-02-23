package com.liuhy.transfer.service;


import com.liuhy.transfer.dao.AccountDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liuhy on 2017/2/22.
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @Override
    public void transfer(String from, String to, int money) {
        accountDao.out(from, money);
        // 断电
        int i = 1/0;
        accountDao.in(to, money);
    }
}
