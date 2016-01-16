package com.core.dao.impl;

import com.core.dao.UserDao;
import com.core.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-21
 * Time: 下午3:44
 * To change this template use File | Settings | File Templates.
 */
@Repository("UserDao")
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public List<User> findUser(User user) {
        String sql = "SELECT * FROM user WHERE user_name='" + user.getUserName() + "' AND password='" + user.getPassword() + "'";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<User>(User.class));
    }
}
