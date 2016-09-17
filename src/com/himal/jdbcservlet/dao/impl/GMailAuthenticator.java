package com.himal.jdbcservlet.dao.impl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by Himal Acharya on 2016-09-15.
 */
public class GMailAuthenticator extends Authenticator {
    String user;
    String pw;
    public GMailAuthenticator (String username, String password)
    {
        super();
        this.user = username;
        this.pw = password;
    }
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(user, pw);
    }
}
