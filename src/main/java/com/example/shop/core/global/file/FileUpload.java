package com.example.shop.core.global.file;

import com.example.shop.core.global.error.FileSaveException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileUpload {
    private static String PATH;

    @Value("${app.filePath}")
    public void setUploadPath(String path) {
        PATH = path;
    }

    public static void uploadImage(MultipartFile file, String location) {
        File targetFile = new File(PATH + location);

        if(!targetFile.isDirectory()) {
            targetFile.mkdirs();
        }

        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            throw new FileSaveException(file.getOriginalFilename());
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(PATH + filePath);

        if (file.exists()) {
            file.delete();
        }
    }
}
