package com.lihuanyu.informationquerysystem.service;

import com.google.gson.Gson;
import com.lihuanyu.informationquerysystem.GsonTemplate.SessionUser;
import com.lihuanyu.informationquerysystem.GsonTemplate.VerifyUserInfo;
import com.lihuanyu.informationquerysystem.config.ProductConfig;
import com.lihuanyu.informationquerysystem.util.MCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by skyADMIN on 16/3/27.
 */
@Service
public class LoginService {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private GetRealMessage getRealMessage;

    public boolean procssAuthReal() throws IOException {
        String access_token = (String) httpSession.getAttribute("access_token");
        String message = getRealMessage.getMessage(access_token,"verify_me");
        return saveRealSession(message);
    }


    /**
     * 保存学校验证信息的session
     * @param message
     * @return
     */
    private boolean saveRealSession(String message) {
        Gson gson = new Gson();
        try{
            VerifyUserInfo verifyUserInfo = gson.fromJson(message, VerifyUserInfo.class);
            if (verifyUserInfo.status.equals("success")) {
                httpSession.setAttribute("realname", verifyUserInfo.info.yb_realname);
                httpSession.setAttribute("studentid", verifyUserInfo.info.yb_studentid);
                return true;
            }else {
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 判断用户是否携带真实信息(学号)
     * @return
     */
    public boolean isAuthReal() {
        if (httpSession.getAttribute("yb_studentid") != null)
            return true;
        else
            return false;
    }

    public ModelAndView toYibanAuth() {
        return new ModelAndView("redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + ProductConfig.client_id + "&redirect_uri=" + ProductConfig.redirect_uri);
    }

    /**
     * 判断用户是否登陆
     *
     * @return
     */
    public boolean isLogin() {
        if (httpSession.getAttribute("userid") != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 处理授权.成功则跳转至/,失败则重新引导用户至易班授权模块
     * @param verify_request 易班服务器提供的信息,加密的.
     * @return
     * @throws Exception
     */
    public String processAuth(String verify_request) throws Exception {
        MCrypt mCrypt = new MCrypt();
        String res = new String(mCrypt.decrypt(verify_request));
        if (saveSession(res)) {
            return "redirect:/";
        } else {
            return "redirect:/yibanauth";
        }
    }

    /**
     * 完成对解密后的json数据的解析,存在session里.解析失败则是未授权用户,引导其至授权界面.
     *
     * @param str
     */
    public boolean saveSession(String str) {
        Gson gson = new Gson();
        try {
            SessionUser sessionUser = gson.fromJson(str, SessionUser.class);
            httpSession.setAttribute("visit_time", sessionUser.visit_time);
            httpSession.setAttribute("userid", sessionUser.visit_user.userid);
            httpSession.setAttribute("username", sessionUser.visit_user.username);
            httpSession.setAttribute("usernick", sessionUser.visit_user.usernick);
            httpSession.setAttribute("usersex", sessionUser.visit_user.usersex);
            httpSession.setAttribute("access_token", sessionUser.visit_oauth.access_token);
            httpSession.setAttribute("token_expires", sessionUser.visit_oauth.token_expires);
            return true;
        } catch (Exception ex) {
            //ex.printStackTrace();
            return false;
        }
    }
}
