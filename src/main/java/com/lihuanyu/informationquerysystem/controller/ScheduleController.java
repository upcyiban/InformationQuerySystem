package com.lihuanyu.informationquerysystem.controller;

import com.lihuanyu.informationquerysystem.GsonTemplate.ClassScheduleInfo;
import com.lihuanyu.informationquerysystem.model.ClassSchedule;
import com.lihuanyu.informationquerysystem.service.GetClassSchedule;
import com.lihuanyu.informationquerysystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/3/29.
 */
@Controller
public class ScheduleController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private GetClassSchedule getClassSchedule;

    @RequestMapping("/schedule")
    public String showSchedule(Model model) throws IOException {
        if (!loginService.isLogin()) {
            return "redirect:/yibanauth";
        } else if (!loginService.isAuthReal()) {
            loginService.procssAuthReal();
        }
        ArrayList<ClassScheduleInfo.ClassInfo> classInfos = getClassSchedule.getMessage(getClassSchedule.getMessageFromWebservice());
        if (classInfos.isEmpty()) {
            model.addAttribute("meike", "meike");
        } else {
            getClassSchedule.showView(model, classInfos);
        }
        return "schedule";
    }

}
