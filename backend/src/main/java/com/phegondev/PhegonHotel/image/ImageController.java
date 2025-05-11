// package com.phegondev.PhegonHotel.image;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;

// public class ImageController {

//     @Autowired
//     private LocalStorageService localStorageService;

//     @PostMapping("/upload-image")
//     public String uploadImage(@RequestParam("file") MultipartFile file) {
//         try {
//             String filePath = localStorageService.saveImage(file);
//             return "Image uploaded successfully: " + filePath;
//         } catch (Exception e) {
//             return "Error uploading image: " + e.getMessage();
//         }
//     }
// }