package com.boardroomone.profilephotoservice.controller;

import com.boardroomone.profilephotoservice.service.ImageUploaderServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/profile-photo")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PhotoUploadController {
    @Autowired
    private ImageUploaderServiceImpl imageUploaderService;

    @SneakyThrows
    @PostMapping("/add-image")
    public Map<?, ?> addImage(@RequestParam("file") MultipartFile file) {
        return imageUploaderService.uploadImage(file);
    }

}
