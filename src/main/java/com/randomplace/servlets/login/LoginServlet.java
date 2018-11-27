package com.randomplace.servlets.login;

import com.randomplace.dto.UserDTO;
import com.randomplace.models.User;
import com.randomplace.security.UserSession;
import com.randomplace.service.login.LoginService;
import com.randomplace.utils.PagePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        List<String> errorList = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(req.getParameter("email"));
        userDTO.setCurrentPassword(req.getParameter("password"));
        User user = loginService.login(userDTO, errorList);
        if (errorList.isEmpty()) {
            UserSession.addUser(req, user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("errors", errorList);
            doGet(req, resp);
        }

    }
}
