package com.randomplace.servlets;

import com.randomplace.service.image.ImageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/image")
public class FileDownloadServlet extends HttpServlet {

    ImageService imageService;

    @Override
    public void init() throws ServletException {
        imageService = ImageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        byte[] file = imageService.getFile(fileName);
        if (file == null) {
            file = imageService.getFile(ImageService.DEFAULT_FILE_NAME);
        }
        resp.getOutputStream().write(file);
        resp.setContentType("image/*");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
