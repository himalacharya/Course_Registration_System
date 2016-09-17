package com.himal.jdbcservlet.constant;

/**
 * Created by Himal Acharya on 2016-09-07.
 */
public class SQLConstant {

    public final static String COURSE_GETALL="SELECT * From "+TableConstant.TABLE_COURSE;
    public final static String COURSE_INSERT="INSERT into tbl_courses(user_name,password,course_name, course_description, course_type,added_date,modified_date,status,course_duration,email) values(?,?,?,?,?,?,?,?,?,?)";
    public final static String COURSE_SELECTED="UPDATE tbl_courses SET course_name=?,course_description=?,course_type=?,modified_date=?,course_duration=?,email=? WHERE course_id=?";
    public final static String COURSE_GETSINGLEID="SELECT * From tbl_courses WHERE course_id=?";
    public final static String COURSE_DELETE="DELETE From tbl_courses WHERE course_id=?";
    public final static String STUDENT_USERNAME_PASSWORD="SELECT user_name,password,status,course_id FROM tbl_courses WHERE user_name=? and password=?";
}
