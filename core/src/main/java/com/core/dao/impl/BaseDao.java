package com.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-22
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
//extends NamedParameterJdbcDaoSupport
public class BaseDao extends JdbcDaoSupport {

    @Autowired
    public final void setSuperDataSource(DataSource dataSource) {
        setDataSource(dataSource);
    }
}