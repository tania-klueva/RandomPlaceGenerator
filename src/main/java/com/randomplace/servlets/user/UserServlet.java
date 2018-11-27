package com.randomplace.servlets.user;

import com.randomplace.models.Place;
import com.randomplace.models.User;
import com.randomplace.security.UserSession;
import com.randomplace.service.place.impl.PlaceService;
import com.randomplace.service.user.impl.UserService;
import com.randomplace.service.validators.Validator;
import com.randomplace.utils.PagePath;
import com.randomplace.utils.PlaceSortingField;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/page")
public class UserServlet extends HttpServlet {



    private PlaceService placeService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = UserService.getOurInstance();
        placeService = PlaceService.getOurInstance();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = UserSession.getCurrentUser(req);
        List<String> errorList = new ArrayList<>();
        if (currentUser != null) {
            String edit = req.getParameter("edit");
            if (edit != null) {
                if (edit.equals("password")) {
                    userService.updatePassword(currentUser, req.getParameter("oldPassword"), req.getParameter("newPassword"), req.getParameter("passwordConfirm"), errorList);
                    if (!errorList.isEmpty()){
                        req.setAttribute("errors", errorList);
                    }else{
                        req.setAttribute("success", "Password changed");
                    }

                } else if (edit.equals("info")) {
                    User user = new User();
                    user.setId(currentUser.getId());
                    user.setEmail(req.getParameter("email"));
                    user.setFirstName(req.getParameter("firstName"));
                    user.setLastName(req.getParameter("lastName"));
                    user.setCity(req.getParameter("city"));
                    userService.update(user, errorList);
                    if (!errorList.isEmpty()) {
                        req.setAttribute("errors", errorList);
                    } else {
                        req.setAttribute("success", "Your information was successfully updated");
                    }
                }
            }
        }
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errorList = new ArrayList<>();
        User currentUser = UserSession.getCurrentUser(req);
        if (currentUser != null){
            req.setAttribute("user", currentUser);
            String page = req.getParameter("page");
            String items = req.getParameter("items");
            if (Validator.isNullOrEmpty(page) || Validator.isNullOrEmpty(items)) {
                page = "1";
                items = "5";
            }
            int numberOfPages = placeService.countNumberOfPagesByUserId( currentUser.getId() ,items, errorList);
            List<Place> allByPage = placeService.findForPagesByUserId(currentUser.getId() ,page, items, PlaceSortingField.ID, errorList);
            if (errorList.isEmpty()) {
                req.setAttribute("places", allByPage);
                req.setAttribute("page", page);
                req.setAttribute("numberOfPages", numberOfPages);
            }else{
                req.setAttribute("userPlaceErrors", errorList);
            }
        }
        req.getRequestDispatcher(PagePath.USER_PAGE).forward(req, resp);
    }
}
