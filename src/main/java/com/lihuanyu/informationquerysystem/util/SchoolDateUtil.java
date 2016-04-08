package com.lihuanyu.informationquerysystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by skyADMIN on 16/4/8.
 */
public class SchoolDateUtil {

    public long  getWeek(){
        Date currentTime = new Date();
        long current = currentTime.getTime();
        long time = 0;
        long begin = 0;
        int week =0;
        String day = null;
        try {
            SimpleDateFormat beginTime = new SimpleDateFormat("yyyy-MM-dd");
            begin = beginTime.parse("2016-02-28").getTime();
            time = current- begin;
        }catch (ParseException e){
            e.printStackTrace();
        }
//        int days = (int) Math.ceil(time/86400000);
        double days = Math.ceil(time/86400000);
        switch ((int)Math.ceil(days)%7){
            case 0: day = "星期日";break;
            case 1: day = "星期一";break;
            case 2: day = "星期二";break;
            case 3: day = "星期三";break;
            case 4: day = "星期四";break;
            case 5: day = "星期五";break;
            case 6: day = "星期六";break;
        }//得到当天是星期几
        week = (int) Math.ceil(days/7);//第几周
        System.out.print("第"+week+"周");
        System.out.print(days);
        System.out.print(day);
        return time;
    }


}
