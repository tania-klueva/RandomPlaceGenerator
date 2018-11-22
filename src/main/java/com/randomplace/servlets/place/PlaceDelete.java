package com.randomplace.servlets.place;

import com.randomplace.models.Place;
import com.randomplace.service.image.ImageService;
import com.randomplace.service.place.impl.PlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/place/delete")
public class PlaceDelete extends HttpServlet {

    PlaceService placeService;
    private ImageService imageService;

    @Override
    public void init() throws ServletException {
        placeService = PlaceService.getOurInstance();
        imageService = ImageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errorList = new ArrayList<>();
        String id = req.getParameter("id");
        Place place = placeService.findById(id, errorList);
        placeService.deleteById(id, errorList);
        imageService.deleteFile(place.getImagePath());
        if (errorList.isEmpty()) {
            resp.sendRedirect("/place");
        }else{
            resp.sendError(404);
        }


    }
}
