package com.core.service;

import com.core.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-21
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public String checkLogin(User user);

    public void logout();
}
