package com.core.service.impl;

import com.core.AccessStatisticsIntceptor;
import com.core.dao.UserDao;
import com.core.entity.User;
import com.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-21
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public String checkLogin(User user) {
        if (userDao.findUser(user).size() == 1) {
            AccessStatisticsIntceptor.userName = user.getUserName();
            return user.getUserName();
        }
        AccessStatisticsIntceptor.userName = "";
        return "";
    }

    @Override
    public void logout() {
        AccessStatisticsIntceptor.userName = "";
    }
}
