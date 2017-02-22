package com.liuhy.hikari;

import com.liuhy.domain.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created by liuhy on 2017/2/22.
 */
public class UserDao extends JdbcDaoSupport {

    public void addUser(User user) {
        this.getJdbcTemplate().
                update("INSERT INTO t_user(username, password) VALUES (?,?);",
                        user.getUsername(),
                        user.getPassword());
    }

    public List<User> findAll() {
        List<User> result;
        result = this.getJdbcTemplate().query("SELECT * FROM t_user", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        });
        return result;
    }

}
