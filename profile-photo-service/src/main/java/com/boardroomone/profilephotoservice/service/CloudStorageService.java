package com.boardroomone.profilephotoservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudStorageService {

    Map<?, ?> uploadImage(MultipartFile file, Map<?, ?> imageProperties) throws IOException;
}
