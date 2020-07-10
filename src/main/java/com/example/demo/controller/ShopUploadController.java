package com.example.demo.controller;

import com.example.demo.model.ShopUpload;
import com.example.demo.service.ShopUploadService;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

@RestController
public class ShopUploadController {

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    ShopUploadService shopUploadService;


    @RequestMapping("/shopUpload/uploadOneshop")
    @ResponseBody
    public JsonResult<String> uploadOneshop(@RequestBody Map<String,Object> param){

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

            ShopUpload shopUpload = new ShopUpload(userId,shopName,shopPrice,shopFactory,shopInfo,sf.format(new Date(System.currentTimeMillis())));
            shopUploadService.uploadShop(shopUpload);
            return new JsonResult<>("","upload success",200);
        }else {
            return new JsonResult<>("","upload failure",500);
        }

    }


}
