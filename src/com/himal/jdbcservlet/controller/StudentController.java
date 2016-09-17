package com.himal.jdbcservlet.controller;

import com.himal.jdbcservlet.entity.Course;
import com.himal.jdbcservlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Himal Acharya on 2016-09-14.
 */
@WebServlet(name = "StudentController",urlPatterns = "/student")
public class StudentController extends HttpServlet {
    UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course user= (Course) request.getSession().getAttribute("loggedInUser");
        System.out.println("Student"+user.getUserName());



        try {
            request.setAttribute("courses", userService.getById(user.getCourseId()));

            request.getRequestDispatcher("studenthome.jsp").forward(request, response);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
