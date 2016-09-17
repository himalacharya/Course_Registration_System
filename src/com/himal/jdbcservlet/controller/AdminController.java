package com.himal.jdbcservlet.controller;

import com.himal.jdbcservlet.entity.Course;
import com.himal.jdbcservlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Himal Acharya on 2016-09-13.
 */
@WebServlet(name = "admin",urlPatterns = "/admin")
public class AdminController extends HttpServlet {

    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();

        Course user= (Course) request.getSession().getAttribute("loggedInUser");

        System.out.println("Admin"+user.getUserName());

        if(user.getUserName().equals("admin")){
            try {
                request.setAttribute("courses", userService.getAll());

                request.getRequestDispatcher("courseList.jsp").forward(request, response);


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }else{
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
