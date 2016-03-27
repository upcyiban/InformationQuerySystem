package com.lihuanyu.informationquerysystem.util;

import com.lihuanyu.informationquerysystem.InformationquerysystemApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by skyADMIN on 16/3/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InformationquerysystemApplication.class)
@WebAppConfiguration
public class QueryUtilTest {

    @Test
    public void testFindCurrentAvailableClassroom(){
        QueryUtil queryUtil = new QueryUtil();
        System.out.println(queryUtil.findCurrentAvailableClassroom());
    }
}
