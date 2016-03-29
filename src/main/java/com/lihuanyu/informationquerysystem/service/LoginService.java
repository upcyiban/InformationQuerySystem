package com.lihuanyu.informationquerysystem.service;

import com.google.gson.Gson;
import com.lihuanyu.informationquerysystem.GsonTemplate.SessionUser;
import com.lihuanyu.informationquerysystem.config.ProductConfig;
import com.lihuanyu.informationquerysystem.util.MCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by skyADMIN on 16/3/27.
 */
@Service
public class LoginService {

    @Autowired
    private HttpSession httpSession;



    public ModelAndView toYibanAuth(){
        return new ModelAndView("redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + ProductConfig.client_id + "&redirect_uri=" + ProductConfig.redirect_uri);
    }

    /**
     * 判断用户是否登陆
     * @return
     */
    public boolean isLogin() {
        if (httpSession.getAttribute("userid") != null){
            return true;
        }else {
            return false;
        }
    }

    public String processAuth(String verify_request) throws Exception {
        MCrypt mCrypt = new MCrypt();
        String res = new String(mCrypt.decrypt(verify_request));
        if (saveSession(res)) {
            return "redirect:/";
        }else {
            return "redirect:/yibanauth";
        }
    }

    /**
     * 完成对解密后的json数据的解析,存在session里.解析失败则是未授权用户,引导其至授权界面.
     * @param str
     */
    public boolean saveSession(String str){
        Gson gson = new Gson();
        try{
            SessionUser sessionUser = gson.fromJson(str,SessionUser.class);
            httpSession.setAttribute("visit_time", sessionUser.visit_time);
            httpSession.setAttribute("userid", sessionUser.visit_user.userid);
            httpSession.setAttribute("username", sessionUser.visit_user.username);
            httpSession.setAttribute("usernick", sessionUser.visit_user.usernick);
            httpSession.setAttribute("usersex", sessionUser.visit_user.usersex);
            httpSession.setAttribute("access_token", sessionUser.visit_oauth.access_token);
            httpSession.setAttribute("token_expires", sessionUser.visit_oauth.token_expires);
            return true;
        }catch (Exception ex){
            //ex.printStackTrace();
            return false;
        }
    }
}
