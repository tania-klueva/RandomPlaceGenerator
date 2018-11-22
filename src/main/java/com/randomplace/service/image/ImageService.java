package com.randomplace.service.image;

import com.randomplace.service.validators.ImageValidator;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public class ImageService {
    private static ImageService ourInstance = new ImageService();
    public static final String PATH = System.getProperty("user.dir") + File.separator + "storage" + File.separator;
    public static final String DEFAULT_FILE_NAME = "default.jpg";
    private ImageValidator validator;

    public static ImageService getInstance() {
        return ourInstance;
    }

    private ImageService() {
        validator = ImageValidator.getOurInstance();
    }

    public String getContentType(Part file) {
        String originalFileName = file.getSubmittedFileName();
        return originalFileName.substring(originalFileName.indexOf("."));
    }

    public String createFileName(Part file) {
        return UUID.randomUUID() + getContentType(file);
    }

    public String writeFile(Part file, List<String> errorList) {
        try {
            String fileName = createFileName(file);
            validator.validate(errorList, getContentType(file));
            try {
                Files.createDirectory(Paths.get(PATH));
            } catch (Exception ignored) {

            }
            if (errorList.isEmpty()) {
                InputStream fileContent = file.getInputStream();
                byte[] buffer = new byte[fileContent.available()];
                fileContent.read(buffer);
                File targetFile = new File(PATH + fileName);
                OutputStream outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
                outStream.close();
                return fileName;
            }
        } catch (Exception ignored) {
        }

        return null;
    }


    public byte[] getFile(String fileName) {
        File file = new File(ImageService.PATH + fileName);
        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            return null;
        }
    }

    public void deleteFile(String fileName) {
        if (!fileName.equals(ImageService.DEFAULT_FILE_NAME)) {
            File file = new File(ImageService.PATH + fileName);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
        }
    }
}

