package com.liuhy.transfer.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by liuhy on 2017/2/22.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void out(String outer, int money) {
        this.getJdbcTemplate()
                .update("UPDATE account SET money = money - ? WHERE username = ?", money, outer);

    }

    @Override
    public void in(String inner, int money) {
        this.getJdbcTemplate()
                .update("UPDATE account SET money = money + ? WHERE username = ?", money, inner);
    }
}
