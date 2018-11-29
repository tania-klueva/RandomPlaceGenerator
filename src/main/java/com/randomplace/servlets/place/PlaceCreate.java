package com.randomplace.servlets.place;

import com.randomplace.models.Place;
import com.randomplace.models.User;
import com.randomplace.security.UserSession;
import com.randomplace.service.image.ImageService;
import com.randomplace.service.place.impl.PlaceService;
import com.randomplace.utils.PagePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig(
        maxFileSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 2,
        maxRequestSize = 1024 * 1024 * 50
)
@WebServlet("/user/place/create")
public class PlaceCreate extends HttpServlet {


    PlaceService placeService;
    private ImageService imageService;

    @Override
    public void init() throws ServletException {
        placeService = PlaceService.getOurInstance();
        imageService = ImageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = UserSession.getCurrentUser(req);
        if (currentUser != null) {
            req.setAttribute("user", currentUser);
        }
        req.getRequestDispatcher(PagePath.CREATE_PLACE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errorList = new ArrayList<>();
        User currentUser = UserSession.getCurrentUser(req);
        if (currentUser != null) {
            req.setAttribute("user", currentUser);
        } else {
            req.getRequestDispatcher(PagePath.ERROR);
        }
        Place place = new Place();
        place.setName(req.getParameter("name"));
        place.setSpecification(req.getParameter("specification"));
        place.setCity(req.getParameter("city"));
        place.setAddress(req.getParameter("address"));
        place.setDescription(req.getParameter("description"));
        Part file = req.getPart("file");
        String fileName = imageService.writeFile(file, errorList);
        if (fileName == null || fileName.isEmpty()) {
            place.setImagePath(ImageService.DEFAULT_FILE_NAME);
        } else {
            place.setImagePath(fileName);
        }
        place.setUser(currentUser);
        placeService.save(place, errorList);
        if (errorList.isEmpty()) {
            resp.sendRedirect("/place");
        } else {
            req.setAttribute("place", place);
            req.setAttribute("errors", errorList);
            doGet(req, resp);
        }
    }

}
