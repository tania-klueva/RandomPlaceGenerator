package com.randomplace.servlets;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        System.out.println(fileName);
        File targetFile = new File(System.getProperty("user.dir")+ File.separator +"storage" +  File.separator +fileName);
        System.out.println(targetFile.exists());
        System.out.println(targetFile.getPath());
        byte[] fileContent = Files.readAllBytes(targetFile.toPath());
        resp.getOutputStream().write(fileContent);
        resp.setContentType("image");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
