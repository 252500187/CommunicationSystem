package com.core.entity;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-21
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String userName;
    private String password;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
