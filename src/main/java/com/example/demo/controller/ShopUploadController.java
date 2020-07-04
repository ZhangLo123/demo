package com.example.demo.controller;

import com.example.demo.model.ShopUpload;
import com.example.demo.service.ShopUploadService;
import com.example.demo.utils.JsonResult;
import com.google.gson.Gson;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class ShopUploadController {
    @Autowired
    ShopUploadService shopUploadService;


    @RequestMapping("/shopUpload/uploadOneshop")
    @ResponseBody
    public JsonResult uploadOneshop(@RequestBody Map<String,Object> param){

        String userId = param.get("userId").toString();
        String shopName = param.get("shopname").toString();
        Integer shopPrice = Integer.parseInt(param.get("shopprice").toString()) ;
        String shopFactory = param.get("shopfactory").toString();
        String shopInfo = param.get("shopinfo").toString();
//        String shopImages = param.get("imList").toString();

        System.out.println("*******************************************************************************");
        System.out.println(shopName);
        System.out.println("*******************************************************************************");

//        List<String> list = Arrays.asList(shopImages.split(","));

//        System.out.println("*******************************************************************************");
//        System.out.println(list);
//        System.out.println("*******************************************************************************");

        if (userId != null){

            ShopUpload shopUpload = new ShopUpload(userId,shopName,shopPrice,shopFactory,shopInfo,System.currentTimeMillis());
            shopUploadService.uploadShop(shopUpload);
            return new JsonResult("","upload success",200);
        }else {
            return new JsonResult("","upload failure",500);
        }

    }


}
