package com.core.dao;

import com.core.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-21
 * Time: 下午3:44
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {

    public List<User> findUser(User user);
}
