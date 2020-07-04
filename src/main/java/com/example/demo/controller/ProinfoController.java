package com.example.demo.controller;

import com.example.demo.model.Images;
import com.example.demo.model.Proinfo;
import com.example.demo.service.ImagesService;
import com.example.demo.service.ProinfoService;
import com.example.demo.service.UserService;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Map;

@Controller
public class ProinfoController {
    @Autowired
    ProinfoService proinfoService;
    @Autowired
    UserService userService;
    @Autowired
    ImagesService imagesService;

    @RequestMapping("/approve/uploadproinfo")
    @ResponseBody
    public JsonResult<Proinfo> uploadoneshop(@RequestBody Map<String,Object> param){

        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();
        String shopName = param.get("shopname").toString();
        String shopPrice =param.get("shopprice").toString();
        String shopFactory = param.get("shopfactory").toString();
        String contact = param.get("contact").toString();
        String volt = param.get("volt").toString();
        String aisle = param.get("aisle").toString();
        String weight = param.get("weight").toString();
        String system = param.get("system").toString();
        String profile =param.get("profile").toString();
        String application = param.get("application").toString();
        String features = param.get("features").toString();

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(userId);
        System.out.println(shopName);
        System.out.println(userToken);
        System.out.println("======================================================");

        String pId = ProinfoController.IDCode();


        if (userId != null && userToken != null){
            Proinfo proinfo = new Proinfo(userId,userToken,pId,shopName,shopPrice,shopFactory,contact,volt,aisle,weight,system,
                    profile,application,features, LocalDate.now());
            proinfoService.UploadShop(proinfo);
            return new JsonResult(proinfo,"upload success",200);
        }else {
            return new JsonResult("","upload failure",500);
        }

    }

    @RequestMapping("/proinfo/uploadmainImg")
    @ResponseBody
    public JsonResult uploadOneImage(@RequestParam("userId") String userId,
                                     @RequestParam("shopId") String shopId,
                                     @RequestParam("shopname") String shopname,
                                     @RequestParam("file") MultipartFile multipartFile){

        System.out.println("++++++++++++++++++++++++++上传主图++++++++++++++++++++++++++++");
        System.out.println(userId);
        System.out.println(shopname);
        System.out.println(shopId);
        System.out.println(multipartFile.toString());
        System.out.println("=============================成功=========================");

        if (userId != null){
            String originalName = multipartFile.getOriginalFilename();
            String filePath = "F:\\app\\product\\image\\uploads\\" + shopname;

            File dir = new File(filePath);
            if (!dir.exists()) { //若创建文件不存在则创建文件夹
                dir.mkdir();
                System.out.println(filePath);
            }

            String picNewName = ProinfoController.RandomCode() + shopname + originalName.substring(originalName.lastIndexOf("."));
            File mainImg = new File(filePath + "\\" + picNewName);

            System.out.println("-------------------------------------------------------");
            System.out.println(mainImg);
            System.out.println("-------------------------------------------------------");
            try{
                multipartFile.transferTo(mainImg);
                Proinfo proinfo = new Proinfo();
                proinfo.setShopId(shopId);
                proinfo.setMainImage(mainImg.toString());
                proinfoService.updatemainImage(proinfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new JsonResult("mainImage","upload success",200);
        }else {
            return new JsonResult(""," failure",500);
        }

    }

    @RequestMapping(value = "/proinfo/uploadcarouselImages",headers = "content-type=multipart/form-data")
    @ResponseBody
    public JsonResult uploadcarouselImages(@RequestParam("userId") String userId,
                                           @RequestParam("shopId") String shopId,
                                           @RequestParam("shopname") String shopname,
                                           @RequestParam("file") MultipartFile multipartFile){

        System.out.println("++++++++++++++++++++++++上传轮播图++++++++++++++++++++++++++++++");
        System.out.println(userId);
        System.out.println(shopname);
        System.out.println(shopId);
        System.out.println(multipartFile.toString());
        System.out.println("=============================成功=========================");

        if (userId != null){
            String originalName = multipartFile.getOriginalFilename();
            String filePath = "F:\\app\\product\\image\\uploads\\" + shopname;

            File dir = new File(filePath);
            if (!dir.exists()) { //若创建文件不存在则创建文件夹
                dir.mkdir();
                System.out.println(filePath);
            }

            String picNewName = ProinfoController.RandomCode() + shopname + originalName.substring(originalName.lastIndexOf("."));
            File mainImg = new File(filePath + "\\" + picNewName);

            System.out.println("-------------------------------------------------------");
            System.out.println(mainImg);
            System.out.println("-------------------------------------------------------");
            try{
                multipartFile.transferTo(mainImg);
                Images images = new Images(userId,shopId,shopname,mainImg.toString(),LocalDate.now());
                imagesService.saveImage(images);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new JsonResult("imagesLunbo","upload success",200);
        }else {
            return new JsonResult("","upload failure",500);
        }

    }


    /**
     * 随机生成字母字符串
     * @return
     */
    public static String RandomCode(){

        SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        String frealDir = sFormat.format(calendar.getTime());

        //生成一个包含大小写字母的随机4位字符串；方法1
        String randomcode = "";
        for(int i=0;i<4;i++)
        {
            //52个字母与6个大小写字母间的符号；范围为91~96
            int value = (int)(Math.random()*58+65);
            while(value>=91 && value<=96)
                value = (int)(Math.random()*58+65);
            randomcode = randomcode + (char)value;

        }
        return frealDir+randomcode;
    }

    /**
     *随机生成pID
     * @return
     */
    public static String IDCode(){

        SimpleDateFormat sFormat = new SimpleDateFormat("yyMMdd");
        Calendar calendar = Calendar.getInstance();
        String frealDir = sFormat.format(calendar.getTime());

        //生成一个包含大小写字母的随机6位字符串；方法1
        String randomcode = "";
        for(int i=0;i<10;i++)
        {
            //52个字母与6个大小写字母间的符号；范围为91~96
            int value = (int)(Math.random()*58+65);
            while(value>=91 && value<=96)
                value = (int)(Math.random()*58+65);
            randomcode = randomcode + (char)value;

        }
        return frealDir+randomcode;
    }
}
