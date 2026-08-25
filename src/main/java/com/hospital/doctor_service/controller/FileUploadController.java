package com.hospital.doctor_service.controller;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/doctors/files")
public class FileUploadController {

    private static final String BUCKET_NAME = "eca-storage-project-f26e7e83";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        BlobInfo blobInfo = BlobInfo.newBuilder(BUCKET_NAME, file.getOriginalFilename()).build();
        storage.create(blobInfo, file.getBytes());
        return "File uploaded successfully: " + file.getOriginalFilename();
    }
}