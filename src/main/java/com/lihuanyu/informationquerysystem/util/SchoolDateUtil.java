package com.lihuanyu.informationquerysystem.util;

import com.lihuanyu.informationquerysystem.config.Config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by skyADMIN on 16/4/8.
 */
public class SchoolDateUtil {

    private long getCurrentTime(){
        Date currentTime = new Date();
        long current = currentTime.getTime();
        return current;
    }

    private double getTime(){
        Config config = new Config();
        long current = getCurrentTime();
        double time = 0;
        long begin = 0;
        try {
            SimpleDateFormat beginTime = new SimpleDateFormat("yyyy-MM-dd");
            begin = beginTime.parse(config.data).getTime();
            time = current - begin;
        }catch (ParseException e){
            e.printStackTrace();
        }
        return time;
    }

    public int getWeek(){
        int week = 0;
        double days = Math.ceil(getTime()/86400000.0);
        week = (int) Math.ceil(days/7);//第几周
        return week;
    }

    public int getDay(){
        int day = 0;
        double days = Math.ceil(getTime()/86400000.0);
        switch ((int)Math.ceil(days)%7){
            case 0: day = 6;break;
            case 1: day = 7;break;
            case 2: day = 1;break;
            case 3: day = 2;break;
            case 4: day = 3;break;
            case 5: day = 4;break;
            case 6: day = 5;break;
        }//得到当天是星期几
        return day;
    }

    public int getWeek(double time){
        int week = 0;
        double days = Math.ceil(time/86400000.0);
        week = (int) Math.ceil(days/7);//第几周
        return week;
    }

    public int getDay(double time){
        int day = 0;
        double days = Math.ceil(time/86400000.0);
        switch ((int)Math.ceil(days)%7){
            case 0: day = 6;break;
            case 1: day = 7;break;
            case 2: day = 1;break;
            case 3: day = 2;break;
            case 4: day = 3;break;
            case 5: day = 4;break;
            case 6: day = 5;break;
        }//得到当天是星期几
        return day;
    }
}
