package com.liuhy.dbcp;

import com.liuhy.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by liuhy on 2017/2/21.
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean update(User user) {
        String sql = "update t_user set username=?, password=? where id=?";
        Object[] args = {user.getUsername(), user.getPassword(), user.getId()};
        jdbcTemplate.update(sql, args);

        return true;
    }
}
