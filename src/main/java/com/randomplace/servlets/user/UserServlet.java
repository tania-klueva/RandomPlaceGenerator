package com.randomplace.servlets.user;

import com.randomplace.models.User;
import com.randomplace.security.UserSession;
import com.randomplace.utils.PagePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/page")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = UserSession.getCurrentUser(req);
        if (currentUser != null){
            req.setAttribute("user", currentUser);
        }
        req.getRequestDispatcher(PagePath.USER_PAGE).forward(req, resp);
    }
}
