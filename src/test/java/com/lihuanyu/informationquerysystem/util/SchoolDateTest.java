package com.lihuanyu.informationquerysystem.util;

import com.lihuanyu.informationquerysystem.InformationquerysystemApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by skyADMIN on 16/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InformationquerysystemApplication.class)
@WebAppConfiguration
public class SchoolDateTest {

    SchoolDateUtil schoolDateUtil = new SchoolDateUtil();

    @Test
    public void testGetWeek(){
        System.out.println(schoolDateUtil.getWeek());
    }

    @Test
    public void testGetDay(){
        System.out.println(schoolDateUtil.getDay());
    }
}
