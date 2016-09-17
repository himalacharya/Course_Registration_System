package com.himal.jdbcservlet.controller;


import com.himal.jdbcservlet.dao.EmailDAO;
import com.himal.jdbcservlet.dao.impl.EmailDAOImpl;
import com.himal.jdbcservlet.entity.Course;
import com.himal.jdbcservlet.entity.Email;
import com.himal.jdbcservlet.service.UserService;
import com.himal.jdbcservlet.system.Controller;


import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;



/**
 * Created by Himal Acharya on 2016-09-08.
 */
@WebServlet("/CourseController")
public class CourseController extends Controller {

    //need to draw from database

    private UserService userService=new UserService();




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course course=new Course();
        course.setCourseName(request.getParameter("courseName"));
        course.setUserName(request.getParameter("userName"));
        course.setPassword(request.getParameter("password"));
        course.setCourseDescription(request.getParameter("courseDescription"));
        course.setCourseDuration (Integer.parseInt(request.getParameter("courseDuration")));
        course.setDurationType(request.getParameter("durationType"));
        course.setAddeddate(new Date());
        course.setModifiedDate(new Date());
        course.setStatus("true");
        course.setEmail(request.getParameter("email"));

        Course user= (Course) request.getSession().getAttribute("loggedInUser");

        String courseID=request.getParameter("courseId");

        if (courseID==null|| courseID.isEmpty()){

            try {
                userService.insert(course);


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                response.sendRedirect("login");
            }

        }else{

            System.out.println(Integer.parseInt(courseID));
            course.setCourseId(Integer.parseInt(courseID));

            try {
                userService.update(course);

               callingController(user,response);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmailDAO emailDAO=new EmailDAOImpl();



        Course user= (Course) request.getSession().getAttribute("loggedInUser");

        String action=request.getParameter("action");

        if(action.equalsIgnoreCase("edit")){
            System.out.println("update button pressed");
            int courseId=Integer.parseInt(request.getParameter("courseId"));
            try {
                request.setAttribute("course",userService.getById(courseId));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("course.jsp").forward(request,response);

        }else if(action.equalsIgnoreCase("delete")){
            int courseId=Integer.parseInt(request.getParameter("courseId"));
            try {
                userService.delete(courseId);
                request.setAttribute("courses",userService.getAll());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            callingController(user,response);



        }else  if(action .equalsIgnoreCase("email")){
            int courseId= Integer.parseInt(request.getParameter("courseId"));
            Email email=new Email();
            try {
                String toEmail=userService.getById(courseId).getEmail();
                email.setTo(toEmail);
                email.setFrom("himalacharya@gmail.com");
                email.setSubject("Test Email");
                email.setBody("This is test/demo");

                System.out.println(email.getTo());

                boolean status=emailDAO.send(email);

                PrintWriter out=response.getWriter();
                if(status){
                    out.println("<h1>Successful</h1>");
                }else{
                    out.println("<h1>Unsuccessful</h1");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());

            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private  void callingController(Course user,HttpServletResponse response) throws IOException {


        if(user.getUserName().equals("admin")){
            response.sendRedirect("/admin");
        }else{
            response.sendRedirect("/student");
        }
    }
}
