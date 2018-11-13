package com.randomplace.servlets;

import com.randomplace.dao.impl.PlaceDAOImpl;
import com.randomplace.models.Place;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    PlaceDAOImpl placeDAO = new PlaceDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CREATE 2 NEW ENTyTIES");
        placeDAO.save(new Place("name1", "w", "add", "trtskfhlsdf"));
        placeDAO.save(new Place("name2", "s", "add", "5465"));
        System.out.println("FINDALL");
        placeDAO.findAll().forEach(System.out::println);
        System.out.println("UPDATING");
        placeDAO.update(new Place(1, "nameNEW", "w", "add", "trtskfhlsdf"));
        System.out.println("FINDBYID");
        System.out.println(placeDAO.findById(1).toString());
        System.out.println("DELETE");
        placeDAO.deleteById(2);
        System.out.println("FINDALL");
        System.out.println(placeDAO.findAll());
        resp.getWriter().print("HALLO");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
