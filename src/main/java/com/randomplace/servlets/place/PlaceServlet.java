package com.randomplace.servlets.place;

import com.randomplace.models.Place;
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
        String id = req.getParameter("id");
        if (Validator.isNullOrEmpty(id)) {
            String page = req.getParameter("page");
            String items = req.getParameter("items");
            if (Validator.isNullOrEmpty(page) || Validator.isNullOrEmpty(items)) {
                page = "1";
                items = "20";
            }
            int numberOfPages = placeService.countNumberOfPages(items, errorList);
            List<Place> allByPage = placeService.findAllByPage(page, items, PlaceSortingField.ID, errorList);
            if (allByPage != null && !allByPage.isEmpty()) {
                req.setAttribute("places", allByPage);
                req.setAttribute("page", page);
                req.setAttribute("numberOfPages", numberOfPages);
                req.getRequestDispatcher(PagePath.PLACE_LIST).forward(req, resp);
            } else {
                errorList.add(PlaceValidationError.NO_PLACES_IN_DB.getErrorText());
            }

//            List<Place> places = placeService.findAll();
//            if (places != null && !places.isEmpty()) {
//                req.setAttribute("places", places);
//                req.getRequestDispatcher(PagePath.PLACE_LIST).forward(req, resp);
//            } else {
//                errorList.add(PlaceValidationError.NO_PLACES_IN_DB.getErrorText());
//            }
        } else {
            Place place = placeService.findById(id, errorList);
            if (errorList.isEmpty()) {
                if (place != null) {
                    req.setAttribute("place", place);
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
