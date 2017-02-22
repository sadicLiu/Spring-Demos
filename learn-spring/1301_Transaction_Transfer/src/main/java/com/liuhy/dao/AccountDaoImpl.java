package com.liuhy.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by liuhy on 2017/2/22.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void out(String outer, int money) {

    }

    @Override
    public void in(String inner, int money) {

    }
}
