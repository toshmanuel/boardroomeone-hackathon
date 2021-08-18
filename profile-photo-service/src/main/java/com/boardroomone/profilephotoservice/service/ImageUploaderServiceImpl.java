package com.boardroomone.profilephotoservice.service;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class ImageUploaderServiceImpl {


    @Autowired
    private CloudStorageService configurationService;
    
    private String extractFileName(String fileName){
        return fileName.split("\\.")[0];
    }


    public String uploadImage(MultipartFile imageFile) throws FileNotFoundException {
        if (imageFile == null) throw new FileNotFoundException("File not found");
        String imageUrl = null;

        if(!imageFile.isEmpty()){
            try {
                final String FOLDER_NAME = "boardroomone/";
                Map<?, ?> uploadResult = configurationService.uploadImage(imageFile,
                        ObjectUtils.asMap("transformation", new Transformation<>().aspectRatio("1:1")
                                        .gravity("face")
                                        .background("black")
                                        .crop("fill"),
                                "public_id",
                                FOLDER_NAME + extractFileName(Objects.requireNonNull(imageFile.getOriginalFilename())))
                );
                imageUrl = (String) uploadResult.get("url");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageUrl;

    }

}
