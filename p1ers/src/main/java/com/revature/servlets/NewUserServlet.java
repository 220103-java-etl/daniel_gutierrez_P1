package com.revature.servlets;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class NewUserServlet extends HttpServlet {
    AuthService aS=new AuthService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("NewUserForm.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        HttpSession session = req.getSession();
        String username =  req.getParameter("username");
        String password=req.getParameter("password");
        String firstName=req.getParameter("firstname");
        String lastName=req.getParameter("lastname");
        String email=req.getParameter("email");
        Role role=Role.valueOf(req.getParameter("role"));

        resp.sendRedirect("employee.html");

        if (role == (Role.EMPLOYEE)) {
            User u = new User(username, password, firstName, lastName, email, role);
            aS.register(u);
            session.setAttribute("user", u);
        } else {
            User u = new User(username, password, firstName, lastName, email, role);
            aS.register(u);
            session.setAttribute("user", u);
        }
    }  catch ( Exception e ) {
            resp.setStatus(401);
        }
    }
}