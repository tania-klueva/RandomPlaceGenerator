package com.randomplace.servlets.place;

import com.randomplace.dao.impl.PlaceDAO;
import com.randomplace.models.Place;
import com.randomplace.models.User;
import com.randomplace.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@MultipartConfig(
        maxFileSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 2,
        maxRequestSize = 1024 * 1024 * 50
)
@WebServlet("/place/create")
public class PlaceCreate extends HttpServlet {


    private PlaceDAO placeDAO;
    private FileUtils fileUtils;

    @Override
    public void init() throws ServletException {
        placeDAO = new PlaceDAO();
        fileUtils = FileUtils.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/place/createPlace.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String specification = req.getParameter("specification");
        String city = req.getParameter("city");
        String address = req.getParameter("address");
        String description = req.getParameter("description");
        try {
            Files.createDirectory(Paths.get(System.getProperty("user.dir")+File.separator + "storage"));
        } catch (Exception e) {
        }
        Part filePart = req.getPart("file");
        String fileName = fileUtils.createFileName(filePart);
        InputStream fileContent = filePart.getInputStream();
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);
        File targetFile = new File("storage/" + fileName);
        System.out.println(targetFile.getAbsolutePath());
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.close();

//
//        Part file = req.getPart("file");
//        String dir = System.getProperty("user.dir")+File.separator + "storage";
//        File file1 = new File(dir);
//        if (!file1.exists()) {
//            file1.mkdirs();
//        }
//        String fileName = fileUtils.createFileName(file);
//        InputStream fileContent = file.getInputStream();
//        byte[] buffer = new byte[fileContent.available()];
//        fileContent.read(buffer);
//        File targetFile = new File(dir + fileName);
//        OutputStream outStream = new FileOutputStream(targetFile);
//        outStream.write(buffer);
//        outStream.close();
        User user = new User();
        user.setId(1);

        /////////////////
        /////////////
        //SAVE ONLY IF  FALE WAS SAVED, pAY ATTENTION PLS
        Place place = new Place(name, specification, city, address, description, fileName, user);
        placeDAO.save(place);
        resp.sendRedirect("/place");
    }

}
