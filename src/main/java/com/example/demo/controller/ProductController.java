package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.utils.JacksonConfig;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.ProductDataInfo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * 获取单个产品信息
     */
    @RequestMapping("/product/findOne")
    @ResponseBody
    public JsonResult findOne(@RequestBody Map<String,Object> param){
        String pname = param.get("proname").toString();

        List<Product> product = productService.findBypName(pname);

        System.out.println("-------------------------------------------------------");
        System.out.println(product);
        System.out.println("-------------------------------------------------------");

        if (product != null){

            return new JsonResult(product,"find success",200);
        }else {
            return new JsonResult("","find failure",404);
        }
    }

//    @RequestMapping("/product/addOne")
//    @ResponseBody
//    public JsonResult addOne(@RequestBody Map<String,Object> param){
//
//    }
}
