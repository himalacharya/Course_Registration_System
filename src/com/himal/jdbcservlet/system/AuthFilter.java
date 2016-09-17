package com.himal.jdbcservlet.system;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Himal Acharya on 2016-09-13.
 */
@WebFilter(filterName = "AuthFilter",urlPatterns ={"/admin","/admin/*","/courseList.jsp","/studenthome.jsp","/student"})
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //making to HTTP servlet
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpServletRequest request= (HttpServletRequest) req;

        HttpSession session=request.getSession(false);

        if(session!=null && session.getAttribute("loggedInUser")!=null){
            //it means users is there in our database

            //we have to allow session
            chain.doFilter(request,response);
        }else{
            //user is not logged in ...needs to login to entry
            response.sendRedirect("/login.jsp?error");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
