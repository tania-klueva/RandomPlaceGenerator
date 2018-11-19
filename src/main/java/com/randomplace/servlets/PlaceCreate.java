package com.randomplace.servlets;

import com.randomplace.dao.impl.PlaceDAOImpl;
import com.randomplace.models.Place;
import com.randomplace.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@MultipartConfig(
        maxFileSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 2,
        maxRequestSize = 1024 * 1024 * 50
)
@WebServlet("/place/create")
public class PlaceCreate extends HttpServlet {


    private PlaceDAOImpl placeDAO;
    private FileUtils fileUtils;

    @Override
    public void init() throws ServletException {
        placeDAO = new PlaceDAOImpl();
        fileUtils = FileUtils.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/createPlace.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String specification = req.getParameter("specification");
        String city = req.getParameter("city");
        String address = req.getParameter("address");
        String description = req.getParameter("description");
        Part file = req.getPart("file");
        String path = getServletContext().getRealPath("");
        String savePath = File.separator +  "resources" + File.separator + "images" + File.separator + fileUtils.createFileName(file);
        file.write(path + savePath);
        Place place = new Place(name, specification, city, address, description, savePath, user);
        placeDAO.save(place);
        resp.sendRedirect("/place");
    }

}
