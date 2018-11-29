package com.randomplace.servlets.user;

import com.randomplace.dto.UserDTO;
import com.randomplace.service.user.impl.UserService;
import com.randomplace.utils.PagePath;

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
        userService = UserService.getOurInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(PagePath.SIGN_UP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> errorList = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(req.getParameter("email"));
        userDTO.setNewPassword(req.getParameter("password"));
        userDTO.setConfirmPassword(req.getParameter("passwordConfirm"));
        userDTO.setFirstName(req.getParameter("firstName"));
        userDTO.setLastName(req.getParameter("lastName"));
        userDTO.setCity(req.getParameter("city"));
        userService.save(userDTO, errorList);
        if (errorList.isEmpty()) {
            resp.sendRedirect("/signin");
        } else {
            req.setAttribute("errors", errorList);
            req.setAttribute("user", userDTO);
            doGet(req, resp);
        }
    }
}
