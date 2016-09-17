package com.himal.jdbcservlet.service;



import com.himal.jdbcservlet.dao.CourseDAO;
import com.himal.jdbcservlet.dao.impl.CourseDAOImpl;
import com.himal.jdbcservlet.entity.Course;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Himal Acharya on 2016-09-09.
 */
public class UserService {
    CourseDAO courseDAO=new CourseDAOImpl();


    public void insert(Course course) throws SQLException, ClassNotFoundException {

        courseDAO.insert(course);
    }

    public List<Course> getAll() throws SQLException, ClassNotFoundException {

        return  courseDAO.getAll();

    }

    public void update(Course course) throws SQLException, ClassNotFoundException {

        courseDAO.update(course);
    }

    public Course getById(int id) throws SQLException, ClassNotFoundException {
        return courseDAO.getById(id);

    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        courseDAO.delete(id);
    }

    public Course login(String username,String password) throws SQLException, ClassNotFoundException {
        return courseDAO.login(username, password);


    }

}
