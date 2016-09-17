package com.himal.jdbcservlet.entity;

/**
 * Created by Himal Acharya on 2016-09-15.
 */
public class Email {

    String to,from,subject,body;

    public Email() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {

        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
