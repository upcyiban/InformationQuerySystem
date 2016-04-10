package com.lihuanyu.informationquerysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by skyADMIN on 16/4/10.
 */
@Controller
public class StaticController {

    @RequestMapping("/about")
    public String showAboutPage() {
        return "about";
    }
}
