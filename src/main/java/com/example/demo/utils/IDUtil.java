package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IDUtil {
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
     *随机生成userID
     * @return
     */
    public static String IDCode(){

        SimpleDateFormat sFormat = new SimpleDateFormat("yyMMdd");
        Calendar calendar = Calendar.getInstance();
        String frealDir = sFormat.format(calendar.getTime());

        //生成一个包含大小写字母的随机6位字符串；方法1
        String randomcode = "";
        for(int i=0;i<6;i++)
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
