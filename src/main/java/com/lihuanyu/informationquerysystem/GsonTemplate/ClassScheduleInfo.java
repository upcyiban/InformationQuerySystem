package com.lihuanyu.informationquerysystem.GsonTemplate;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/4/8.
 */
public class ClassScheduleInfo {

    public ArrayList<ClassScheduleInfo.ClassInfo> Table;

    public class ClassInfo implements Comparable{
        public String XH;
        public String SKSJ;
        public String KKXQM;
        public String KCMC;
        public String JXDD;
        public String JSXM;
        public String SKZCMX;

        @Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = PRIME * result;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            return KCMC.equals(((ClassInfo)obj).KCMC) && SKSJ.equals(((ClassInfo)obj).SKSJ);
        }

        @Override
        public int compareTo(Object o) {
            if (KCMC.equals(((ClassInfo)o).KCMC) && SKSJ.equals(((ClassInfo)o).SKSJ))
                return 0;
            else
                return 1;
        }
    }
}
