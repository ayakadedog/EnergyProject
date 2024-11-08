package com.energy.controller;

import com.energy.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传和下载
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            log.error("Uploaded file is empty or null");
            return Result.error("No file uploaded");
        }

        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        log.info("Original filename: {}", originalFilename);

        if (originalFilename == null || originalFilename.isEmpty()) {
            return Result.error("File name is empty");
        }

        // 获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + suffix;

        // 获取当前工作目录，并拼接上传路径
        String uploadDir = "/templates/picture/"+fileName;
        System.out.println(uploadDir);

        // 创建文件夹
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                return Result.error("Failed to create directory");
            }
        }

        // 上传文件保存路径
        File dest = new File(uploadDir + File.separator + fileName);
        try {
            file.transferTo(dest);
            log.info("File uploaded successfully to: {}", dest.getAbsolutePath());
        } catch (IOException e) {
            log.error("File upload failed", e);
            return Result.error("File upload failed");
        }

        return Result.success(fileName);

    }

    /**
     * 文件下载
     *
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {

        try {
            // 通过 ClassPathResource 获取文件资源
            Resource resource = new ClassPathResource("templates/picture/" + name);

            if (!resource.exists()) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("File not found!");
                return;
            }

            // 获取资源的输入流
            InputStream inputStream = resource.getInputStream();

            // 设置响应的内容类型为图片
            response.setContentType("image/jpeg");

            // 输出流，通过输出流将文件写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();

            int len;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }

            // 关闭资源
            outputStream.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                response.getWriter().write("Error occurred while processing the file.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}


//file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除
//        log.info(file.toString());
//
//        //原始文件名
//        String originalFilename = file.getOriginalFilename();
//        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//
//        //使用UUID重新生成文件名，防止文件名称重复造成文件覆盖
//        String fileName = UUID.randomUUID().toString() + suffix;
//
//        //创建一个目录对象
//        File dir = new File(basePath);
//        //判断当前目录是否存在
//        if (!dir.exists()) {
//            //目录不存在，需要创建
//            dir.mkdirs();
//        }
//
//        try {
//            //将临时文件转存到指定位置
//            file.transferTo(new File(basePath + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return Result.success(fileName);


//        try {
//
//            //输入流，通过输入流读取文件内容
//            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
//
//            //输出流，通过输出流将文件写回浏览器
//            ServletOutputStream outputStream = response.getOutputStream();
//
//            response.setContentType("image/jpeg");
//
//            int len = 0;
//            byte[] bytes = new byte[1024];
//            while ((len = fileInputStream.read(bytes)) != -1) {
//                outputStream.write(bytes, 0, len);
//                outputStream.flush();
//            }
//
//            //关闭资源
//            outputStream.close();
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }