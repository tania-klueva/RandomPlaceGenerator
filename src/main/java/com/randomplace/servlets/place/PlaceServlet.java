package com.randomplace.servlets.place;

import com.randomplace.dao.impl.PlaceDAO;
import com.randomplace.models.Place;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/place")
public class PlaceServlet extends HttpServlet{

    private PlaceDAO placeDAO;

    @Override
    public void init() throws ServletException {
        placeDAO = new PlaceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id==null || id.isEmpty() ){
            List<Place> places = placeDAO.findAll();
            if (places != null && places.size()>0){
                req.setAttribute("places", places);
                req.getRequestDispatcher("/views/place/places.jsp").forward(req, resp);
            }
        } else{
            Place place = placeDAO.findById(Integer.parseInt(id));
            if (place !=null){
                req.setAttribute("place", place);
                req.getRequestDispatcher("/views/place/place.jsp").forward(req, resp);
            }

        }
        resp.sendError(404);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
