package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.WXUser;
import com.example.demo.service.WXUserService;
import com.example.demo.utils.IDUtil;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class WeChatController {

    private static final String appid = "wx62202b9474e1b146";
    private static final String secret = "0461d0d18d49cf8f2c90c2a8a3cc0bf1";
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    WXUserService wxUserService;

    @RequestMapping("/user/weinxinLogin.php")
    @ResponseBody
    public JsonResult wLogin(@RequestBody Map<String, Object> param) throws Exception {
        String nickName = param.get("nickname").toString();
        String gender = param.get("gender").toString();
        String faceUrl = param.get("faceUrl").toString();
        String js_code = param.get("code").toString();
        String nowTime = sf.format(new Date(System.currentTimeMillis()));

        String wxResult = doGet(appid, secret, js_code);
        System.out.println(wxResult);

        if (wxResult == null || "".equals(wxResult)){
            return new JsonResult("", "failure", 500);

        }else {

            Map map = JSON.parseObject(wxResult);

            String openid = map.get("openid").toString();

            System.out.println(openid);

            WXUser wxUserList = wxUserService.findByOpenID(openid);
            System.out.println(wxUserList);

            if (wxUserList == null || "".equals(wxResult)) {
                WXUser wxUser = new WXUser(openid, IDUtil.IDCode(),nickName, gender, faceUrl, nowTime);
                wxUserService.saveWXUser(wxUser);
                return new JsonResult(wxUser, "registerSuccess", 202);

            }else{
                return new JsonResult(wxUserList, "loginSuccess", 200);
            }
        }

    }

    /**
     * 发送get请求
     */
    public static String doGet(String appid, String secret, String js_code) throws Exception {


        StringBuffer param = new StringBuffer();
        param.append("appid=" + appid);
        param.append("&secret=" + secret);
        param.append("&js_code=" + js_code);
        param.append("&grant_type=" + "authorization_code");


        URL localURL = new URL("https://api.weixin.qq.com/sns/jscode2session?");
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(param.length()));

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        String resultBuffer = "";

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);

            outputStreamWriter.write(param.toString());
            outputStreamWriter.flush();

            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }

            inputStream = httpURLConnection.getInputStream();
            resultBuffer = convertStreamToString(inputStream);

        } finally {

            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }

        }

        return resultBuffer;
    }

    /**
     * 转换返回值类型为UTF-8格式.
     *
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        StringBuilder sb1 = new StringBuilder();
        byte[] bytes = new byte[4096];
        int size = 0;

        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "UTF-8");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }
}
