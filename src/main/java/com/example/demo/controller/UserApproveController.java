package com.example.demo.controller;


import com.example.demo.model.UserApprove;
import com.example.demo.service.UserApproveService;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class UserApproveController {
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    UserApproveService userApproveService;

    @RequestMapping("/approve/approveInfo")
    @ResponseBody
    public JsonResult<UserApprove> addApprove(@RequestBody Map<String,Object> param){

        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();
        String gscname = param.get("gscname").toString();
        String gsename = param.get("gsename").toString();
        String buslicense = param.get("buslicense").toString();
        String regaddress = param.get("regaddress").toString();
        String busaddress = param.get("busaddress").toString();
        String regdate = param.get("regdate").toString();
        String regfund = param.get("regfund").toString();
        String representative = param.get("representative").toString();
        String companytype = param.get("companytype").toString();
        String applicant = param.get("applicant").toString();
        String applicantdepart = param.get("applicantdepart").toString();
        String applicantpost = param.get("applicantpost").toString();
        String status = "待审核";

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(userId);
        System.out.println(userToken);
        System.out.println("======================================================");
        if (userId != null && userId != ""){
            List<UserApprove> userApproveList = userApproveService.findApprove(userId);
            if (userApproveList.size() != 0 ){
                UserApprove userApprove = new UserApprove(userId,userToken,gscname,gsename,buslicense,
                        regaddress,busaddress,regdate,regfund,representative,companytype,applicant,applicantdepart,applicantpost, sf.format(new Date(System.currentTimeMillis())),status);
                userApproveService.updateApprove(userApprove);
                return new JsonResult(userApprove,"true",200);
            }else {
                UserApprove userApprove = new UserApprove(userId,userToken,gscname,gsename,buslicense,
                        regaddress,busaddress,regdate,regfund,representative,companytype,applicant,applicantdepart,applicantpost, sf.format(new Date(System.currentTimeMillis())),status);
                userApproveService.putApply(userApprove);
                return new JsonResult(userApprove,"true",200);
            }
        }else {
            return new JsonResult("","false",500);
        }

    }

    @RequestMapping("/approve/approveLimit")
    @ResponseBody
    public JsonResult findApproveLimit(@RequestBody Map<String,Object> param){
        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();

        if (userId != null && userToken != null){

            return new  JsonResult("","true",200);
        }else {
            return new JsonResult("","false",500);
        }
    }


}
