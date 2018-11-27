package com.randomplace.servlets.place;

import com.randomplace.models.Place;
import com.randomplace.models.User;
import com.randomplace.security.UserSession;
import com.randomplace.service.place.impl.PlaceService;
import com.randomplace.service.validators.Validator;
import com.randomplace.utils.PagePath;
import com.randomplace.utils.PlaceSortingField;
import com.randomplace.utils.errorMessages.PlaceValidationError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/place")

public class PlaceServlet extends HttpServlet {

    private PlaceService placeService;

    @Override
    public void init() throws ServletException {
        placeService = PlaceService.getOurInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errorList = new ArrayList<>();
        User currentUser = UserSession.getCurrentUser(req);
        String id = req.getParameter("id");
        if (Validator.isNullOrEmpty(id)) {
            String page = req.getParameter("page");
            String items = req.getParameter("items");
            String sort = req.getParameter("sort");
            String search = req.getParameter("search");

            if (Validator.isNullOrEmpty(page) || Validator.isNullOrEmpty(items)) {
                page = "1";
                items = "10";
            }
            int numberOfPages = placeService.countNumberOfPages(items, search, errorList);
            List<Place> allByPage = placeService.findAllByPage(page, items, sort, search, errorList);
            if (errorList.isEmpty()) {
                req.setAttribute("places", allByPage);
                req.setAttribute("items", items);
                req.setAttribute("page", page);
                req.setAttribute("numberOfPages", numberOfPages);
                req.setAttribute("sort", sort);
                req.getRequestDispatcher(PagePath.PLACE_LIST).forward(req, resp);
            }
        } else {
            Place place = placeService.findById(id, errorList);
            if (errorList.isEmpty()) {
                if (place != null) {
                    req.setAttribute("place", place);
                    if (currentUser!= null && currentUser.equals(place.getUser())){
                        req.setAttribute("canEdit", true);
                    }else{
                        req.setAttribute("canEdit", false);
                    }
                    req.getRequestDispatcher(PagePath.PLACE_PAGE).forward(req, resp);
                } else {
                    resp.sendError(404);
                }
            }
        }
        if (!errorList.isEmpty()) {
            req.setAttribute("errors", errorList);
            req.getRequestDispatcher(PagePath.PLACE_LIST).forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
