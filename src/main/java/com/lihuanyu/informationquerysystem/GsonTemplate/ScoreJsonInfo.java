package com.lihuanyu.informationquerysystem.GsonTemplate;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/3/30.
 */
public class ScoreJsonInfo {

    public ArrayList<ScoreInfo> Table;

    public class ScoreInfo implements Comparable{
        public String XQM;
        public int KCCJ;
        public String KCMC;

        @Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = PRIME * result + KCCJ;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
//            if (KCMC.equals(((ScoreInfo)obj).KCMC) && KCCJ == ((ScoreInfo) obj).KCCJ)
//                return true;
//            else
//                return false;
            return KCMC.equals(((ScoreInfo)obj).KCMC);
        }

        @Override
        public int compareTo(Object o) {
            if (KCMC.equals(((ScoreInfo)o).KCMC) && KCCJ == ((ScoreInfo) o).KCCJ)
                return 0;
            else
                return 1;
        }
    }
}
