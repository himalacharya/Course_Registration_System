package com.himal.jdbcservlet.dao.impl;


import com.himal.jdbcservlet.constant.SQLConstant;
import com.himal.jdbcservlet.dao.CourseDAO;
import com.himal.jdbcservlet.entity.Course;
import com.himal.jdbcservlet.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Himal Acharya on 2016-09-07.
 */
public class CourseDAOImpl implements CourseDAO {



    PreparedStatement preparedStatement = null;

    Connection con=null;


    public CourseDAOImpl() {
        try {
            con=DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getAll() throws ClassNotFoundException, SQLException {


        List<Course> courseList=new ArrayList<>();

        preparedStatement=con.prepareStatement(SQLConstant.COURSE_GETALL);

        ResultSet rs=preparedStatement.executeQuery(SQLConstant.COURSE_GETALL);

        while (rs.next()){
            Course course=new Course();
            course.setCourseId(rs.getInt(1));
            course.setUserName(rs.getString(2));
            course.setPassword(rs.getString(3));

            course.setCourseName(rs.getString(4));
            course.setCourseDescription(rs.getString(5));
            course.setDurationType(rs.getString(6));
            course.setAddeddate(rs.getDate(7));
            course.setModifiedDate(rs.getDate(8));
            course.setStatus(rs.getString(9));
            course.setCourseDuration(rs.getInt(10));
            course.setEmail(rs.getString(11));

            courseList.add(course);



        }
        return courseList;



    }

    @Override
    public void insert(Course course) {

        try {
            preparedStatement =con.prepareStatement(SQLConstant.COURSE_INSERT);
            preparedStatement.setString(1,course.getUserName());
            preparedStatement.setString(2,course.getPassword());
            preparedStatement.setString(3, course.getCourseName());
            preparedStatement.setString(4, course.getCourseDescription());
            preparedStatement.setString(5, course.getDurationType());
            preparedStatement.setDate(6, new Date(course.getAddeddate().getTime()));
            preparedStatement.setDate(7, new Date(course.getModifiedDate().getTime()));
            preparedStatement.setString(8, course.getStatus());
            preparedStatement.setInt(9, course.getCourseDuration());
            preparedStatement.setString(10,course.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        DBConnection.closeAll(preparedStatement);

    }

    @Override    public void update(Course course) throws ClassNotFoundException, SQLException {
        preparedStatement =con.prepareStatement(SQLConstant.COURSE_SELECTED);



        preparedStatement.setString(1,course.getCourseName());
        preparedStatement.setString(2,course.getCourseDescription());
        preparedStatement.setString(3,course.getDurationType());

        preparedStatement.setDate(4, new Date(course.getModifiedDate().getTime()));

        preparedStatement.setInt(5,course.getCourseDuration());

        preparedStatement.setString(6,course.getEmail());

        preparedStatement.setInt(7,course.getCourseId());



        preparedStatement.executeUpdate();


    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException {
        preparedStatement=con.prepareStatement(SQLConstant.COURSE_DELETE);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Course getById(int id) throws ClassNotFoundException, SQLException {
        Course course=new Course();

        preparedStatement=con.prepareStatement(SQLConstant.COURSE_GETSINGLEID);
        preparedStatement.setInt(1,id);
        ResultSet rs=preparedStatement.executeQuery();

        while (rs.next()){

            course.setCourseId(rs.getInt(1));
            course.setUserName(rs.getString(2));
            course.setPassword(rs.getString(3));

            course.setCourseName(rs.getString(4));
            course.setCourseDescription(rs.getString(5));
            course.setDurationType(rs.getString(6));
            course.setAddeddate(rs.getDate(7));
            course.setModifiedDate(rs.getDate(8));
            course.setStatus(rs.getString(9));
            course.setCourseDuration(rs.getInt(10));
            course.setEmail(rs.getString(11));

        }
        return course;

    }

    @Override
    public Course login(String username, String password) throws SQLException {
        Course course=new Course();

        preparedStatement=con.prepareStatement(SQLConstant.STUDENT_USERNAME_PASSWORD);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet rs=preparedStatement.executeQuery();

        if (rs.next()){
            course.setUserName(rs.getString("user_name"));
            course.setPassword(rs.getString("password"));
            course.setStatus(rs.getString("status"));
            course.setCourseId(rs.getInt("course_id"));
        }

        return course;


    }
}
