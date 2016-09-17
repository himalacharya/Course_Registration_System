package com.himal.jdbcservlet.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Himal Acharya on 2016-09-07.
 */
public interface GenericDAO<T> {

        List<T> getAll() throws ClassNotFoundException,SQLException;
        void insert(T t) throws ClassNotFoundException,SQLException;


        void update(T t) throws ClassNotFoundException,SQLException;

        void delete(int id) throws ClassNotFoundException,SQLException;

        T getById(int id)throws ClassNotFoundException,SQLException;

        T login(String username,String password)throws ClassNotFoundException,SQLException;





}
