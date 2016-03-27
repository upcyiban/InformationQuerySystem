package com.lihuanyu.informationquerysystem.GsonTemplate;

/**
 * Created by skyADMIN on 16/3/4.
 */

/**
 * 解析Json用的模板.对应易班提供的/user/real_me接口
 */
public class RealUserInfo {
    public String status;
    public RealInfo info;
    public class RealInfo{
        public int yb_userid;
        public String yb_username;
        public String yb_usernick;
        public char yb_sex;
        public int yb_money;
        public int yb_exp;
        public String yb_userhead;
        public int yb_schoolid;
        public String yb_schoolname;
        public String yb_regtime;
        public String yb_realname;
        public String yb_studentid;
        public String yb_identity;
    }
}
