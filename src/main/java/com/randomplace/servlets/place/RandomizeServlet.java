package com.randomplace.servlets.place;

import com.randomplace.models.Place;
import com.randomplace.service.place.impl.PlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/randomize")
public class RandomizeServlet extends HttpServlet {
    private PlaceService placeService;

    @Override
    public void init() throws ServletException {
        placeService = PlaceService.getOurInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxId = placeService.findMaxId();
        Place place = null;
        if (maxId != -1) {
            while (place == null) {
                int number = (int) (Math.random() * maxId + 1);
                System.out.println(number);
                place = placeService.findById(number);
            }
        }
        resp.sendRedirect("/place?id=" + place.getId());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
