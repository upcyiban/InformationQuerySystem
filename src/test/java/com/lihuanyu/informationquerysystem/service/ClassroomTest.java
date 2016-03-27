package com.lihuanyu.informationquerysystem.service;

import com.lihuanyu.informationquerysystem.InformationquerysystemApplication;
import com.lihuanyu.informationquerysystem.model.ClassroomMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by skyADMIN on 16/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InformationquerysystemApplication.class)
@WebAppConfiguration
public class ClassroomTest {

    public String testMessage = "南教空闲： 105,218,219,300,302,303,304,312,313,315,316,317,318,319,401,402,403,501,502,503,504。 南堂空闲： 116,118,208,218,221,305,309,315,316,317,318,321,322,401,403,408,409,416,417,418,420,508,521。 东环空闲： 105,106。 西环空闲： 106,107,306。 东廊空闲： 101,201,203,301,302,303。 西廊空闲： 101,103,201,202,203,301,302,303。";

    @Autowired
    private AvailableClassroomService availableClassroomService;

    @Test
    public void testClassroom(){
        ClassroomMessage classroomMessage = availableClassroomService.processMessage(testMessage);
        System.out.println(classroomMessage.getDhLists());
    }

}
