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

    public ClassroomMessage processMessage(String message){
        ClassroomMessage classroomMessage = new ClassroomMessage();
        if (message.equals("所有教室当前均无课")){
            classroomMessage.setAllNull(true);
            return classroomMessage;
        }else {
            String[] result = message.split("： |。 ");
            classroomMessage.setNjLists(result[1]);
            classroomMessage.setNtLists(result[3]);
            classroomMessage.setDhLists(result[5]);
            classroomMessage.setXhLists(result[7]);
            classroomMessage.setDlLists(result[9]);
            classroomMessage.setXlLists(result[11]);
            return classroomMessage;
        }
    }

    public String getMessage(){
        return queryUtil.findCurrentAvailableClassroom();
    }
}
