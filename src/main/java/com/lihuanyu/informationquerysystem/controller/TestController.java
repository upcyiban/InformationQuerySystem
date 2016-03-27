package com.lihuanyu.informationquerysystem.controller;

import com.lihuanyu.informationquerysystem.util.QueryUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/3/24.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    QueryUtil queryUtil = new QueryUtil();

    @RequestMapping("/chengji")
    public String showChengji(String studentid){
        if (studentid == null){
            return "请输入学号";
        }
        return queryUtil.findStudentScore(studentid);
    }

    @RequestMapping("/kebiao")
    public String showKebiao(String studentid){
        if (studentid == null){
            return "请输入学号";
        }
        return queryUtil.findClassInfo(studentid);
    }

    @RequestMapping("/classroom")
    public String showAvailableClassroom(String week,String day,String n){
        if (week == null || day == null || n == null){
            return queryUtil.findCurrentAvailableClassroom();
        }else {
            return queryUtil.findAvailableClassroomByTime(week,day,n);
        }

    }
}
