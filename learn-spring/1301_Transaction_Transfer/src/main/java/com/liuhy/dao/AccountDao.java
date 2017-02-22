package com.liuhy.dao;

/**
 * Created by liuhy on 2017/2/22.
 */
public interface AccountDao {
    public void out(String outer, int money);

    public void in(String inner, int money);
}
