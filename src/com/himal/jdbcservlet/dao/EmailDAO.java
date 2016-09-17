package com.himal.jdbcservlet.dao;

import com.himal.jdbcservlet.entity.Email;

/**
 * Created by Himal Acharya on 2016-09-15.
 */
public interface EmailDAO {
    boolean send(Email email);

}
