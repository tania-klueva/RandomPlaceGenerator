package com.randomplace.utils;

import javax.servlet.http.Part;
import java.sql.Timestamp;
import java.util.UUID;

public class FileUtils {
    private static FileUtils ourInstance = new FileUtils();

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
}
