package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@RestController
@RequestMapping("/getCode.do")
public class PhoneCodeController {

    // 用户名
    String name="dxwhqb";
    // 密码
    String pwd="2CBC974A8F7A29BB37C3B981DA3D";
    // 签名
    String sign="";
    // 追加发送时间，可为空，为空为及时发送
    String stime="";
    // 扩展码，必须为数字 可为空
    StringBuffer extno=new StringBuffer();

    @GetMapping
    public void codeTest(HttpServletRequest req, HttpServletResponse res){

        //生成一个4位数的验证码
        String strCode = "";
        for (int i=0;i<4;i++){
            strCode+=(int)Math.floor(Math.random()*10);
        }

        String phone = req.getParameter("phone");
        StringBuffer mobileString = new StringBuffer(phone);
        StringBuffer contextString = new StringBuffer("【搜索助手】尊敬的用户，您好！您的手机验证码为:"+strCode+"。此验证码用于认证，5分钟之内有效，请即时使用。");

        try {
            System.out.println(sendMsg(name,pwd,mobileString,contextString,sign,stime,extno));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *发送短信
     * @param
     * @return
     * @throws Exception
     */
    public static String sendMsg(String name, String pwd,
                                 StringBuffer mobileString, StringBuffer contextString,
                                 String sign, String stime, StringBuffer extno) throws Exception {


        StringBuffer param = new StringBuffer();
        param.append("name="+name);
        param.append("&pwd="+pwd);
        param.append("&mobile=").append(mobileString);
        param.append("&content=").append(URLEncoder.encode(contextString.toString(),"UTF-8"));
        param.append("&sign=").append(URLEncoder.encode(sign,"UTF-8"));
        param.append("&stime="+stime);
        param.append("&type=pt");
        param.append("&extno=").append(extno);


        URL localURL = new URL("http://web.duanxinwang.cc/asmx/smsservice.aspx?");
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
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
     *转换返回值类型为UTF-8格式.
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
