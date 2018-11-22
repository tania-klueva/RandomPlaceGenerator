package com.randomplace.servlets.user;

import com.randomplace.models.Role;
import com.randomplace.models.User;
import com.randomplace.service.user.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/signup")
public class UserCreate extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> errorList = new ArrayList<>();
        User user = new User();
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setCity(req.getParameter("city"));
        user.setRole(Role.USER);
        String passwordConfirm = req.getParameter("passwordConfirm");
        userService.save(user, passwordConfirm, errorList);
        if (errorList.isEmpty()) {
            resp.sendRedirect("/signin");
        } else {
            req.setAttribute("error", errorList);
            req.getRequestDispatcher("/views/user/signUp.jsp").forward(req, resp);
        }
    }
}
