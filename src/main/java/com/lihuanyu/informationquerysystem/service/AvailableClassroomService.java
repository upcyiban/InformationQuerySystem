package com.lihuanyu.informationquerysystem.service;

import com.lihuanyu.informationquerysystem.model.ClassroomMessage;
import com.lihuanyu.informationquerysystem.util.QueryUtil;
import org.springframework.stereotype.Service;

/**
 * Created by skyADMIN on 16/3/27.
 */
@Service
public class AvailableClassroomService {

    QueryUtil queryUtil = new QueryUtil();

    public ClassroomMessage processMessage(String message) {
        ClassroomMessage classroomMessage = new ClassroomMessage();
        classroomMessage.currentTime = "当前可自习的教室";
        return tidyMessage(classroomMessage, message);
    }

    public String getMessage() {
        return queryUtil.findCurrentAvailableClassroom();
    }

    public ClassroomMessage processByTimeMessage(String message) {
        ClassroomMessage classroomMessage = new ClassroomMessage();
        String[] resone = message.split("课,");
        classroomMessage.currentTime = resone[0];
        String middleMessage = resone[1];
        return tidyMessage(classroomMessage, middleMessage);
    }

    /**
     * 整理自习室信息
     * @param c
     * @param m
     * @return
     */
    public ClassroomMessage tidyMessage(ClassroomMessage c, String m) {
        if (m.equals("所有教室当前均无课")) {
            c.njLists = "均可自习";
            c.ntLists = "均可自习";
            c.dhLists = "均可自习";
            c.xhLists = "均可自习";
            c.dlLists = "均可自习";
            c.xlLists = "均可自习";
            c.allNull = true;
        } else {
            String[] result = m.split("：|。");
            c.njLists = result[1];
            c.ntLists = result[3];
            c.dhLists = result[5];
            c.xhLists = result[7];
            c.dlLists = result[9];
            c.xlLists = result[11];
        }
        return c;
    }
}
