package com.randomplace.servlets;

import com.randomplace.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/image")
public class FileDownloadServlet extends HttpServlet {

    FileUtils fileUtils;

    @Override
    public void init() throws ServletException {
        fileUtils = FileUtils.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        byte[] file = fileUtils.getFile(fileName);
        if (file == null){
            file = fileUtils.getFile(FileUtils.DEFAULT_FILE_NAME);
        }
        resp.getOutputStream().write(file);
        resp.setContentType("image");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
