package com.lihuanyu.informationquerysystem.util;

import com.lihuanyu.informationquerysystem.InformationquerysystemApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by skyADMIN on 16/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InformationquerysystemApplication.class)
@WebAppConfiguration
public class SchoolDateTest {

    SchoolDateUtil schoolDateUtil = new SchoolDateUtil();

    @Test
    public void testGetWeek() throws ParseException {
        SimpleDateFormat beginTime = new SimpleDateFormat("yyyy-MM-dd");
        long begin = beginTime.parse("2016-02-28").getTime();
        long current = beginTime.parse("2016-04-01").getTime();
        System.out.println(" ");
        //System.out.println(current);
        //System.out.println(schoolDateUtil.getCurrentTime());
        double time = current - begin + 1;
        System.out.println(schoolDateUtil.getWeek(time));
    }

    @Test
    public void testGetDay() throws ParseException {
        SimpleDateFormat beginTime = new SimpleDateFormat("yyyy-MM-dd");
        long begin = beginTime.parse("2016-02-28").getTime();
        long current = beginTime.parse("2016-03-09").getTime();
        System.out.println(" ");
        //System.out.println(current);
        //System.out.println(schoolDateUtil.getCurrentTime());
        double time = current - begin + 1;
        System.out.println(schoolDateUtil.getDay(time));
    }
}
