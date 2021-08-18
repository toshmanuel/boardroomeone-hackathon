package com.boardroomone.profilephotoservice.service;

import com.cloudinary.Cloudinary;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Service
public class CloudinaryImpl implements CloudStorageService {

    Cloudinary cloudinary;

    @Autowired
    public CloudinaryImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public Map<?, ?> uploadImage(MultipartFile file, Map<?, ?> imageProperties) throws IOException {
        Response res = removeImageBackground(file);
        Content content = res.returnContent();
        byte[] fileAsBytes = content.asBytes();
        return cloudinary.uploader().upload(fileAsBytes, imageProperties);
    }

    public Response removeImageBackground(MultipartFile file) throws IOException{
        return Request.Post("https://api.remove.bg/v1.0/removebg")
                .addHeader("X-Api-Key", "qZLsEDXMT4Jva2mSyxjHPAZd")
                .body(
                        MultipartEntityBuilder.create()
                                .addBinaryBody("image_file", file.getInputStream())
                                .addTextBody("size", "auto")
                                .build()
                ).execute();
    }


}
