package com.lihuanyu.informationquerysystem.model;

/**
 * Created by skyADMIN on 16/4/8.
 */
public class ClassSchedule {

    public String coursesName;
    public String coursesLocation;
    public String coursesTime;

    @Override
    public boolean equals(Object obj) {
        return (coursesName.equals(((ClassSchedule)obj).coursesName) && coursesLocation.equals(((ClassSchedule)obj).coursesLocation) && coursesTime.equals(((ClassSchedule)obj).coursesTime));
    }
}
