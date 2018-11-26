package com.randomplace.servlets.place;

import com.randomplace.models.Place;
import com.randomplace.service.image.ImageService;
import com.randomplace.service.place.impl.PlaceService;
import com.randomplace.utils.PagePath;
import com.randomplace.utils.errorMessages.PlaceValidationError;

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

@WebServlet("/user/place/edit")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 2,
        maxRequestSize = 1024 * 1024 * 50
)
public class PlaceEdit extends HttpServlet {

    private PlaceService placeService;
    private ImageService imageService;

    @Override
    public void init() throws ServletException {
        placeService = PlaceService.getOurInstance();
        imageService = ImageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errorList = new ArrayList<>();
        String id = req.getParameter("id");
        Place place = placeService.findById(id, errorList);
        if (errorList.isEmpty()) {
            if (place != null) {
                req.setAttribute("place", place);
                req.getRequestDispatcher(PagePath.EDIT_PLACE).forward(req, resp);
            } else {
                resp.sendError(404);
            }
        } else {
            req.getRequestDispatcher(PagePath.EDIT_PLACE).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errorList = new ArrayList<>();
        Place place = new Place();
        String id = req.getParameter("placeId");
        if (id == null || id.isEmpty()) {
            errorList.add(PlaceValidationError.ID_ERROR.getErrorText());
        } else {
            place.setId(Integer.parseInt(id));
            place.setName(req.getParameter("name"));
            place.setSpecification(req.getParameter("specification"));
            place.setCity(req.getParameter("city"));
            place.setAddress(req.getParameter("address"));
            place.setDescription(req.getParameter("description"));
            String imagePath = req.getParameter("imagePath");
            Part file = req.getPart("file");
            String fileName = imageService.writeFile(file, errorList);
            if (fileName == null || fileName.isEmpty()) {
                place.setImagePath(imagePath);
            } else {
                place.setImagePath(fileName);
                imageService.deleteFile(imagePath);
            }
            placeService.update(place, errorList);
        }
        if (errorList.isEmpty()) {
            resp.sendRedirect("/place");
        } else {
            req.setAttribute("errors", errorList);
            req.setAttribute("place", place);
            doGet(req, resp);
        }
    }
}
