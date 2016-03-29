package com.lihuanyu.informationquerysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by skyADMIN on 16/3/29.
 */
@Controller
public class ScheduleController {

    @RequestMapping("/schedule")
    public String showSchedule(){
        return "schedule";
    }

}
