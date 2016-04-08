package com.lihuanyu.informationquerysystem.service;

import com.google.gson.Gson;
import com.lihuanyu.informationquerysystem.GsonTemplate.ClassScheduleInfo;
import com.lihuanyu.informationquerysystem.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Created by skyADMIN on 16/4/8.
 */
@Service
public class GetClassSchedule {

    QueryUtil queryUtil = new QueryUtil();

    @Autowired
    private HttpSession httpSession;


    public ArrayList<ClassScheduleInfo.ClassInfo> removeDuplicteScoreMessage(ArrayList<ClassScheduleInfo.ClassInfo> classInfos){
        LinkedHashSet<ClassScheduleInfo.ClassInfo> s= new LinkedHashSet<ClassScheduleInfo.ClassInfo>(classInfos);
        return new ArrayList<ClassScheduleInfo.ClassInfo>(s);
    }

    public ArrayList<ClassScheduleInfo.ClassInfo> getMessage(String jsonMessage) {
        Gson gson = new Gson();
        ClassScheduleInfo classScheduleInfo = gson.fromJson(jsonMessage, ClassScheduleInfo.class);
        return classScheduleInfo.Table;
    }

    public String getMessageFromWebservice() {
        String studentid = (String) httpSession.getAttribute("studentid");
        return queryUtil.findClassInfo(studentid);
    }
}
