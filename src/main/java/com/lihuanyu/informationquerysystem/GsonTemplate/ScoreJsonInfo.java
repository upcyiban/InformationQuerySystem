package com.lihuanyu.informationquerysystem.GsonTemplate;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/3/30.
 */
public class ScoreJsonInfo {

    public ArrayList<ScoreInfo> Table;

    public class ScoreInfo implements Comparable {
        private String ID;
        private String XH;//学号
        private String XNXQM;//学期
        private String KSRQ;
        private String KCH;
        private String KCXZMC;//课程类型
        private String KCLBMC;
        private String PSCJ;
        private String KSXZID;
        private String KSXZ;//考试类型
        private String KSXSM;
        private String KHFS;
        private String ZCJ;//成绩
        private String FSLKSCJ;
        private String DJLKSCJ;
        private String KCDJCJM;
        private String RKJSGH;
        private String JGH;
        private String USERREALNAME;//教师
        private String CJLRRQ;
        private String CJLRSJ;
        private String XF;
        private String CJLRFSDM;
        private String KCSX;
        private String KCSXMC;//必修or选修
        private String BJMC;//班级
        private String KXH;
        public String KCMC;//课程

        @Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = (PRIME * result) + Integer.valueOf(ZCJ);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            return KCMC.equals(((ScoreInfo) obj).KCMC);
        }

        @Override
        public int compareTo(Object o) {
            if (KCMC.equals(((ScoreInfo) o).KCMC) && Integer.valueOf(ZCJ) == Integer.valueOf(((ScoreInfo) o).ZCJ)) {
                return 0;
            } else
                return 1;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getXH() {
            return XH;
        }

        public void setXH(String XH) {
            this.XH = XH;
        }

        public String getXNXQM() {
            return XNXQM;
        }

        public void setXNXQM(String XNXQM) {
            this.XNXQM = XNXQM;
        }

        public String getKSRQ() {
            return KSRQ;
        }

        public void setKSRQ(String KSRQ) {
            this.KSRQ = KSRQ;
        }

        public String getKCH() {
            return KCH;
        }

        public void setKCH(String KCH) {
            this.KCH = KCH;
        }

        public String getKCXZMC() {
            return KCXZMC;
        }

        public void setKCXZMC(String KCXZMC) {
            this.KCXZMC = KCXZMC;
        }

        public String getKCLBMC() {
            return KCLBMC;
        }

        public void setKCLBMC(String KCLBMC) {
            this.KCLBMC = KCLBMC;
        }

        public String getPSCJ() {
            return PSCJ;
        }

        public void setPSCJ(String PSCJ) {
            this.PSCJ = PSCJ;
        }

        public String getKSXZID() {
            return KSXZID;
        }

        public void setKSXZID(String KSXZID) {
            this.KSXZID = KSXZID;
        }

        public String getKSXZ() {
            return KSXZ;
        }

        public void setKSXZ(String KSXZ) {
            this.KSXZ = KSXZ;
        }

        public String getKSXSM() {
            return KSXSM;
        }

        public void setKSXSM(String KSXSM) {
            this.KSXSM = KSXSM;
        }

        public String getKHFS() {
            return KHFS;
        }

        public void setKHFS(String KHFS) {
            this.KHFS = KHFS;
        }

        public String getZCJ() {
            return ZCJ;
        }

        public void setZCJ(String ZCJ) {
            this.ZCJ = ZCJ;
        }

        public String getFSLKSCJ() {
            return FSLKSCJ;
        }

        public void setFSLKSCJ(String FSLKSCJ) {
            this.FSLKSCJ = FSLKSCJ;
        }

        public String getDJLKSCJ() {
            return DJLKSCJ;
        }

        public void setDJLKSCJ(String DJLKSCJ) {
            this.DJLKSCJ = DJLKSCJ;
        }

        public String getKCDJCJM() {
            return KCDJCJM;
        }

        public void setKCDJCJM(String KCDJCJM) {
            this.KCDJCJM = KCDJCJM;
        }

        public String getRKJSGH() {
            return RKJSGH;
        }

        public void setRKJSGH(String RKJSGH) {
            this.RKJSGH = RKJSGH;
        }

        public String getJGH() {
            return JGH;
        }

        public void setJGH(String JGH) {
            this.JGH = JGH;
        }

        public String getUSERREALNAME() {
            return USERREALNAME;
        }

        public void setUSERREALNAME(String USERREALNAME) {
            this.USERREALNAME = USERREALNAME;
        }

        public String getCJLRRQ() {
            return CJLRRQ;
        }

        public void setCJLRRQ(String CJLRRQ) {
            this.CJLRRQ = CJLRRQ;
        }

        public String getCJLRSJ() {
            return CJLRSJ;
        }

        public void setCJLRSJ(String CJLRSJ) {
            this.CJLRSJ = CJLRSJ;
        }

        public String getXF() {
            return XF;
        }

        public void setXF(String XF) {
            this.XF = XF;
        }

        public String getCJLRFSDM() {
            return CJLRFSDM;
        }

        public void setCJLRFSDM(String CJLRFSDM) {
            this.CJLRFSDM = CJLRFSDM;
        }

        public String getKCSX() {
            return KCSX;
        }

        public void setKCSX(String KCSX) {
            this.KCSX = KCSX;
        }

        public String getKCSXMC() {
            return KCSXMC;
        }

        public void setKCSXMC(String KCSXMC) {
            this.KCSXMC = KCSXMC;
        }

        public String getBJMC() {
            return BJMC;
        }

        public void setBJMC(String BJMC) {
            this.BJMC = BJMC;
        }

        public String getKXH() {
            return KXH;
        }

        public void setKXH(String KXH) {
            this.KXH = KXH;
        }

        public String getKCMC() {
            return KCMC;
        }

        public void setKCMC(String KCMC) {
            this.KCMC = KCMC;
        }
    }
}
