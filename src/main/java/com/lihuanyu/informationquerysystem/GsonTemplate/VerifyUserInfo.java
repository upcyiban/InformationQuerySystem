package com.lihuanyu.informationquerysystem.GsonTemplate;

/**
 * Created by skyADMIN on 16/3/30.
 */
public class VerifyUserInfo {
    public String status;
    public RealInfo info;

    public class RealInfo {
        public int yb_userid;
        public String yb_realname;
        public String yb_schoolid;
        public String yb_schoolname;
        public String yb_studentid;
        public String code;
        public String msgCN;
        public String msgEN;
    }
}
