package com.randomplace.servlets;

import com.randomplace.dao.impl.PlaceDAOImpl;
import com.randomplace.models.Place;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/place/edit")
public class PlaceEdit extends HttpServlet {

    private PlaceDAOImpl placeDAO;

    @Override
    public void init() throws ServletException {
        placeDAO = new PlaceDAOImpl();
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        Place place = null;
//        if (id == null || id.isEmpty()) {
//            place = new Place();
//            place.setId(-1);
//        } else {
//            placeDAO.findById(Integer.parseInt(id));
//        }
//        if (place != null) {
//            req.setAttribute("place", place);
//        }
//        req.getRequestDispatcher("/views/createPlace.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        String specification = req.getParameter("specification");
//        String address = req.getParameter("address");
//        String description = req.getParameter("description");
//        Place place = new Place(Integer.parseInt(id), name, specification, address, description);
//        if (place.getId() == -1) {
//            placeDAO.save(place);
//        } else {
//            placeDAO.update(place);
//        }
//        resp.sendRedirect("/place");
//    }
}
