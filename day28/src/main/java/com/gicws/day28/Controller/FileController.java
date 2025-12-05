package com.gicws.day28.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        try{
            // Simulate file processing
            String fileName = file.getOriginalFilename();
            long fileSize = file.getSize();
            // Here you would typically save the file to disk or cloud storage
            System.out.println("Received file: " + fileName + " of size: " + fileSize + " bytes");
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error uploading file: " + e.getMessage());
        }

    }
}
