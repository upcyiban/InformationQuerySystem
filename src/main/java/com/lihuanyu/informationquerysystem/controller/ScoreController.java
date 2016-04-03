package com.lihuanyu.informationquerysystem.controller;

import com.lihuanyu.informationquerysystem.GsonTemplate.ScoreJsonInfo;
import com.lihuanyu.informationquerysystem.service.GetScore;
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
public class ScoreController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private GetScore getScore;

    @RequestMapping("/score")
    public String showScore(Model model) throws IOException {
        if (!loginService.isLogin()){
            return "redirect:/yibanauth";
        }else if (!loginService.isAuthReal()){
            loginService.procssAuthReal();
        }
        ArrayList<ScoreJsonInfo.ScoreInfo> scoreList = getScore.getScoreList(getScore.getSorceFromWebservice());
        //System.out.println(getScore.getSorceFromWebservice());
        if (scoreList.isEmpty()){
            model.addAttribute("result","无成绩");
        }
        getScore.showView(model, scoreList);
        return "score";
    }
}
