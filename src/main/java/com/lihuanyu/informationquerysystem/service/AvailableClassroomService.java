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
        if (message.equals("所有教室当前均无课")) {
            classroomMessage.njLists = "均可自习";
            classroomMessage.ntLists = "均可自习";
            classroomMessage.dhLists = "均可自习";
            classroomMessage.xhLists = "均可自习";
            classroomMessage.dlLists = "均可自习";
            classroomMessage.xlLists = "均可自习";
            classroomMessage.allNull = true;
            return classroomMessage;
        } else {
            String[] result = message.split("：|。");
            classroomMessage.njLists = result[1];
            classroomMessage.ntLists = result[3];
            classroomMessage.dhLists = result[5];
            classroomMessage.xhLists = result[7];
            classroomMessage.dlLists = result[9];
            classroomMessage.xlLists = result[11];
            return classroomMessage;
        }
    }

    public String getMessage() {
        return queryUtil.findCurrentAvailableClassroom();
    }
}
