package com.randomplace.utils;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUtils {
    private static FileUtils ourInstance = new FileUtils();
    public static final String PATH = System.getProperty("user.dir") + File.separator + "storage" + File.separator;
    public static final String DEFAULT_FILE_NAME = "default.jpg";

    public static FileUtils getInstance() {
        return ourInstance;
    }

    private FileUtils() {
    }

    public String createFileName(Part file) {
        String originalFileName = file.getSubmittedFileName();
        String contentType = originalFileName.substring(originalFileName.indexOf("."));
        return UUID.randomUUID() + contentType;
    }

    public String writeFile(Part file) {
        try {
            String fileName = createFileName(file);
            Files.createDirectory(Paths.get(PATH));
            InputStream fileContent = file.getInputStream();
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);
            File targetFile = new File(PATH + fileName);
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            outStream.close();
            return fileName;
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] getFile(String fileName) {
        File file = new File(FileUtils.PATH + fileName);
        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            return null;
        }
    }

    public boolean deleteFile(String fileName){
        File file = new File(FileUtils.PATH + fileName);
        return file.delete();
    }
}

