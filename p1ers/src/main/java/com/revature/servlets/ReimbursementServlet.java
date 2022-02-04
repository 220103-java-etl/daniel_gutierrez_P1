//package com.revature.servlets;
//
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class ReimbursementServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String id = req.getParameter("id");
//            Double amount = req.getParameter("amount");
//            String author = req.getParameter("author");
//            String submitted = req.getParameter("submitted");
//            String type = req.getParameter("type");
//            String description = req.getParameter("description");
//            String decision = req.getParameter("decision");
//
//        resp.getWriter().println("id");
////    }
//}


//pseudocode: daniel reimbursemt servlet. take the parameters from the
//new reimbursement form and try to grab the information from the client side
// and create an HTTP session so that there is a sense of security. I need there to need to be a post() to interact
// with dbeaver and my reimbursements table.



// Manager Console: I need to have a page where the manager can accept or deny the request. I can use ajax or i can use the fetch function
// and have the resolve function be the acceptance and the reject be the denied function. I can have a setTimeout function to have the pending
//status appear to the employee.


// Reimbursement History: I need the reimbursement history to find by userId and push this information on to the client side
//so that the employee asking for the request can see how much money they have already asked for and if they are even eligible for
//another request within their given limit.

// I need a 404 and logout servlet. I would like there to be a page that pops up when information is incorrect when entering into
//the login form. the login form will then refresh with a warning popup letting the user know how many tries left with a n-- counter

//Create a FormData() object, collect all the data that needs to be sent to the server.
//        As in the introduction, set fetch to method: "POST" and append the data body: data.
//        Take note of if (result.status != 200) { THROW ERROR } here. For you guys who are new, fetch will consider it a “success” as long as the server responds – Even when the server responds with errors like 4o4 (not found), 403 (unauthorized), and 500 (internal server error). So, it is safer to do a manual 200 (OK) check here.
//        The server response in a string. Use this to show a success/failure message to the user.
//        Handle any errors. Optional, but highly recommended.