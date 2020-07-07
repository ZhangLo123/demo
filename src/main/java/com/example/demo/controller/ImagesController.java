package com.example.demo.controller;

import com.example.demo.model.Images;
import com.example.demo.service.ImagesService;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ImagesController {

    @Autowired
    ImagesService imagesService;

//    @RequestMapping("/images/upload")
//    @ResponseBody
//    public JsonResult uploadImages(@RequestParam("userId") String userId, @RequestParam("files") MultipartFile[] multipartFiles) {
//
//        System.out.println("********************************************************");
//        System.out.println(userId);
//        System.out.println("********************************************************");
//        System.out.println(multipartFiles.toString());
//        System.out.println("********************************************************");
//        System.out.println(multipartFiles.length);
//        System.out.println("********************************************************");
////        String originalName = multipartFile.getOriginalFilename();
//        String fileName = UUID.randomUUID().toString().replace("-", "");
////        System.out.println("-------------------------------------------------------");
////        System.out.println(fileName);
////        System.out.println("-------------------------------------------------------");
////        String filePath = "F:\\app\\product\\image\\uploads\\";
////        String picNewName = fileName + originalName.substring(originalName.lastIndexOf("."));
//
//
//        List<String> list = new ArrayList<>();
//        if (multipartFiles != null && multipartFiles.length > 0) {
//            for (int i = 0; i < multipartFiles.length; i++) {
//                MultipartFile file = multipartFiles[i];
//                // 保存文件
//                String imagePath = saveFile(file);
//                list.add(imagePath);
//            }
//            System.out.println(list);
//            return new JsonResult("", "upload success", 200);
//        }
//        System.out.println(list);
//        return new JsonResult("", "upload failure", 500);
//    }
//
////        try {
////            File imageFile = new File(filePath + picNewName);
////            System.out.println("-------------------------------------------------------");
////            System.out.println(imageFile);
////            System.out.println("-------------------------------------------------------");
////            multipartFile.transferTo(imageFile);
////
////            return new JsonResult("", "upload success", 200);
////        } catch (IOException e) {
////            e.printStackTrace();
////            return new JsonResult("", "upload failure", 500);
////        }
////    }
//
//
//    private String saveFile(MultipartFile file) {
//
////        List<String> list = new ArrayList<>();
//        // 判断文件是否为空
//        if (!file.isEmpty()) {
//            try {
//                // 保存的文件路径
//                // (如果用的是Tomcat服务器，
//                // 文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中)
////                String filePath = request.getSession().getServletContext()
////                        .getRealPath("/")
////                        + "upload/" + file.getOriginalFilename();
//                String originalName = file.getOriginalFilename();
//                String fileName = UUID.randomUUID().toString().replace("-", "");
//                String filePath = "F:\\app\\product\\image\\uploads\\";
//                String picNewName = fileName + originalName.substring(originalName.lastIndexOf("."));
//
//                File saveDir = new File(filePath + picNewName);
//                System.out.println(saveDir);
//
//                // 转存文件
//                file.transferTo(saveDir);
//
//                return filePath;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return "file为空";
//    }



    @RequestMapping("/images/uploadFile")
    @ResponseBody
    public JsonResult uploadFile(@RequestBody MultipartFile[] multipartFiles,String userId,String userName) {

        System.out.println("===============================");
        System.out.println(userId);
        System.out.println(userName);
        System.out.println(multipartFiles);
        System.out.println("===============================");

//
//
//        if (userId != null) {
//            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");  //创建一个list接受前端发送的文件
//            SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
//            Calendar calendar = Calendar.getInstance();
//            String frealDir = sFormat.format(calendar.getTime());
//            String filePath = "F:\\app\\product\\image\\uploads\\" + userName; //指定上传的路径
//            File dir = new File(filePath);
//            if (!dir.exists()) { //若创建文件不存在则创建文件夹
//                dir.mkdir();
//                System.out.println(filePath);
//            }
//            for (MultipartFile f : files) { //用foreach处理list列表中的file
//                if (f.isEmpty()) {  //若某个文件为空则上传失败
//                    return new JsonResult("", "失败，文件为空", 404);
//                }
//                String originalName = f.getOriginalFilename();
//
//                String fileName1 = UUID.randomUUID().toString().replace("-", "");
//
//                String fileName = frealDir + fileName1 + originalName.substring(originalName.lastIndexOf("."));//获取某个上传文件的文件名
//                File dest = new File(filePath + "\\" + fileName);
//                String frealPath = filePath + "\\" + fileName;
//                System.out.println(frealPath);
//                try {
//                    f.transferTo(dest); //写入文件流
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return new JsonResult("", "upload failure", 500);
//                }
//
////                Images images = new Images( userId,frealPath,System.currentTimeMillis());
////                imagesService.saveImage(images);
//            }
//
//
//            return new JsonResult("", "upload success", 200);
//
//        }
//        return new JsonResult("", "Not logged in", 400);


        return new JsonResult("","chenggong",200);
    }



    @RequestMapping("/images/proInfoList")
    @ResponseBody
    public JsonResult proInfoList(){
         List<Images> imagesList = imagesService.findImage(17);
         System.out.println(imagesList);
         List<String> imgUrl = new ArrayList<>();
         
         for (int i = 0; i<imagesList.size();i++){
              String imPath = imagesList.get(i).getImPathLunbo();
              imgUrl.add(imPath);
             System.out.println(imPath);
         }
         System.out.println(imgUrl.toString());

        return new JsonResult(imgUrl,"success",200);
    }


    @PostMapping(value = "/images/addUploadFile", headers = "content-type=multipart/form-data")
    @ResponseBody
    public  Map<String, Object> uploadFile(MultipartRequest request,Integer num){
        Map<String,Object> map = new HashMap<String,Object>();
        // 这样就可以收到文件了，files.length == 1.
        System.err.println(num+"=============================");
        List<MultipartFile> files=new ArrayList<MultipartFile>();
        for (int i=0;i<num;i++){
            System.err.println(request.getFile("image"+i)+"=============================");
            files.add(request.getFile("image"+i));
        }
        System.err.println(files.size()+"=============================");
        // 后续操作省略
        map.put("success", true);
        System.out.println(map.toString());
        return map;
    }
}
