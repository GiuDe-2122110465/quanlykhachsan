// package com.phegondev.PhegonHotel.image;

// import java.io.File;

// import org.springframework.web.multipart.MultipartFile;

// import io.jsonwebtoken.io.IOException;

// public class LocalStorageService {

//     // Định nghĩa thư mục lưu ảnh
//     private final String uploadDir = "/path/to/your/uploads/"; // Cập nhật với đường dẫn thư mục

//     public String saveImage(MultipartFile file) throws IOException {
//         // Kiểm tra xem thư mục lưu trữ có tồn tại không, nếu không thì tạo nó
//         File dir = new File(uploadDir);
//         if (!dir.exists()) {
//             dir.mkdirs();
//         }

//         // Lấy tên file gốc
//         String fileName = file.getOriginalFilename();
//         File serverFile = new File(uploadDir + fileName);

//         // Lưu tệp lên server
//         file.transferTo(serverFile);

//         // Trả về URL của ảnh lưu trữ
//         return "/uploads/" + fileName;
//     }
// }
