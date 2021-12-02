package com.wd.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zzg
 * @Description: 时间类的测试
 * @DateTime: 2021/11/27 9:58
 */
public class Test1 {
    public static void main(String[] args) {
        //获取当前的系统时间
        Date date = new Date();
        //转换日期的格式范围
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        //将其获取的日期时间转换成日期格式，并以字符串的方式进行存储
        String format = simpleDateFormat.format(date);
        //过年的时间
        String year = "2022年02月01日 00时00分00秒";
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long l = date1.getTime() - date.getTime();


        System.out.println("距离过年还有" + l/1000/3600/24+'天');

    }
}
