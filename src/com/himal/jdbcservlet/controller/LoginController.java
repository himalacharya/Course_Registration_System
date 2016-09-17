package com.himal.jdbcservlet.controller;


import com.himal.jdbcservlet.entity.Course;
import com.himal.jdbcservlet.service.UserService;
import com.himal.jdbcservlet.system.Controller;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Himal Acharya on 2016-09-13.
 */

@WebServlet("/login")
public class LoginController extends Controller {



    UserService userService=new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");



        try {
            Course user = userService.login(username,password);
            HttpSession session = req.getSession(true);


            if(user.getStatus()==null){
                resp.sendRedirect("/login.jsp?error");

            }else if(!user.getStatus().equals("true")){
                resp.sendRedirect("/login.jsp?inactive");
            }else if((username.equals("admin")) && password.equals("admin1234")){
                //to maintain that client is being connected and so we need to maintain session


                //session is created and put in object
                session.setAttribute("loggedInUser", user);
                resp.sendRedirect("admin");
            }else  {
                //to maintain that client is being connected and so we need to maintain session
               // HttpSession session = req.getSession();

                //session is created and put in object
                session.setAttribute("loggedInUser", user);
                resp.sendRedirect("student");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {


        }


    }

}
