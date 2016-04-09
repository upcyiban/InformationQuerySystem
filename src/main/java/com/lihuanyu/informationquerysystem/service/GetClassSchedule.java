package com.lihuanyu.informationquerysystem.service;

import com.google.gson.Gson;
import com.lihuanyu.informationquerysystem.GsonTemplate.ClassScheduleInfo;
import com.lihuanyu.informationquerysystem.model.ClassSchedule;
import com.lihuanyu.informationquerysystem.util.QueryUtil;
import com.lihuanyu.informationquerysystem.util.SchoolDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Created by skyADMIN on 16/4/8.
 */
@Service
public class GetClassSchedule {

    QueryUtil queryUtil = new QueryUtil();
    SchoolDateUtil schoolDateUtil = new SchoolDateUtil();

    @Autowired
    private HttpSession httpSession;

    public void showView(Model model, ArrayList<ClassScheduleInfo.ClassInfo> classInfos) {
        classInfos = removeDuplicteCoursesMessage(classInfos);
        ArrayList<ClassSchedule> classSchedules = tidyMessage(classInfos);
        model.addAttribute("classSchedules",classSchedules);
    }

    /**
     * 整理对象成需要的模型对象.
     * @param coursesInfo
     * @return
     */
    public ArrayList<ClassSchedule> tidyMessage(ArrayList<ClassScheduleInfo.ClassInfo> coursesInfo) {
        int week = schoolDateUtil.getWeek();
        int day = schoolDateUtil.getDay();
        ArrayList<ClassSchedule> classSchedules = new ArrayList<ClassSchedule>();
        for (int i = 0; i < coursesInfo.size(); i++) {
            ClassScheduleInfo.ClassInfo temp = coursesInfo.get(i);
            String[] skzc = temp.SKZCMX.split(",");
            for (int j = 1; j < skzc.length; j++) {
                if (Integer.parseInt(skzc[j]) == week) {
                    int tempDay = Integer.parseInt(temp.SKSJ.substring(0,1));
                    if (tempDay == day){
                        ClassSchedule classSchedule = new ClassSchedule();
                        classSchedule.coursesLocation = temp.JXDD;
                        classSchedule.coursesTime = temp.SKSJ.substring(1);
                        classSchedule.coursesName = temp.KCMC;
                        classSchedules.add(classSchedule);
                    }
                }
            }
        }
        return classSchedules;
    }

    public ArrayList<ClassScheduleInfo.ClassInfo> removeDuplicteCoursesMessage(ArrayList<ClassScheduleInfo.ClassInfo> classInfos) {
        LinkedHashSet<ClassScheduleInfo.ClassInfo> s = new LinkedHashSet<ClassScheduleInfo.ClassInfo>(classInfos);
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
