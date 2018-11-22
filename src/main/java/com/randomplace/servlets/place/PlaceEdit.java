package com.randomplace.servlets.place;

import com.randomplace.dao.impl.PlaceDAO;
import com.randomplace.models.Place;
import com.randomplace.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/place/edit")
public class PlaceEdit extends HttpServlet {

    private PlaceDAO placeDAO;

    @Override
    public void init() throws ServletException {
        placeDAO = new PlaceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Place place = null;
        if (id == null || id.isEmpty()) {
            resp.sendRedirect("/place/create");
        } else {
            place = placeDAO.findById(Integer.parseInt(id));
        }
        if (place != null) {
            req.setAttribute("place", place);
            req.getRequestDispatcher("/views/place/editPlace.jsp").forward(req, resp);
        }else {
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getUserPrincipal();
        Place place = new Place();
        String id = req.getParameter("id");
        place.setName(req.getParameter("name"));
        place.setSpecification(req.getParameter("specification"));
        place.setCity(req.getParameter("city"));
        place.setAddress(req.getParameter("address"));
        place.setDescription(req.getParameter("description"));
        place.setImagePath(req.getParameter("imagePath"));
        place.setUser(user);
        placeDAO.update(place);
        resp.sendRedirect("/place");
    }
}
