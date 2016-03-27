package com.lihuanyu.informationquerysystem.controller;

import com.lihuanyu.informationquerysystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by skyADMIN on 16/3/27.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/yibanauth")
    public ModelAndView auth(){
        return loginService.toYibanAuth();
    }
}
