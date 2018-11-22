package com.randomplace.servlets.login;

import com.randomplace.models.User;
import com.randomplace.service.login.LoginService;
import com.randomplace.utils.PagePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/signin")
public class LoginServlet extends HttpServlet {
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        loginService = LoginService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PagePath.SIGN_IN).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<String> errorList = new ArrayList<>();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = loginService.login(email, password, errorList);
        if (errorList.isEmpty()) {
            session.setAttribute("id", user.getId());
            session.setAttribute("ROLE", user.getRole());
            resp.sendRedirect("/");
        } else {
            req.setAttribute("errors", errorList);
            doGet(req, resp);
        }

    }
}
