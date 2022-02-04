package com.revature.servlets;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;
import com.revature.services.AuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;




public class newReimbursementServlet extends HttpServlet {
    ReimbursementDAO reimbursementDAO = new ReimbursementDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Double amount = Double.parseDouble(req.getParameter("amount"));
        String type = req.getParameter("type");
        String description = req.getParameter("description");

        User author = (User) session.getAttribute("user"); //this cast user session to push into author so we can use the current user as the author of the requests
        Status s = Status.PENDING;
        try {
            Reimbursement reimbursement = new Reimbursement(0, s, author, amount, description, type);
            reimbursementDAO.create(reimbursement);
            System.out.println(reimbursement);


//            (id, status, author, amount, description, type);
        } catch (Exception e) {
            resp.setStatus(401);
        }
    }
}
