package com.revature.servlets;


//import com.revature.models.AbstractUser;
import com.revature.models.User;
import com.revature.services.AuthService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    AuthService authService=new AuthService();
// all http methods will be protected and void, daniel
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("signUp.html");
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=  req.getParameter("username");
        String password= req.getParameter("password");

//        System.out.println("Servlet " + username);
//        System.out.println("Servlet " + password);
        HttpSession session = req.getSession();
        User u = authService.login(username, password);


//        session.setAttribute("user",u);
        if(u != null ){
            session.setAttribute("user",u);
            resp.sendRedirect("employee.html");
//            session.setAttribute("user",u);
        }
        else{
            resp.setStatus(401);
        }

// could use getWriter object to write response.getWriter.write("Welcome Back," + username + "!")
    }
}