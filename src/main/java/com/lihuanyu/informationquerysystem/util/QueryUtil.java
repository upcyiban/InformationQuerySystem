package com.lihuanyu.informationquerysystem.util;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * Created by skyADMIN on 16/3/24.
 */
public class QueryUtil {

    private String url = "http://pws.upc.edu.cn:8099/main.asmx"; // 在浏览器中打开url，可以找到
    private String namespace = "http://upcwx.upc.edu.cn/";// targetNamespace
    //private String actionURI = "SearchClass_Room_Now"; // Action路径
    //private String op = "SearchClass_Room_Now"; // 要调用的方法名

    /**
     * 查找指定时间的空教室
     * @param week
     * @param day
     * @param n
     * @return
     */
    public String findAvailableClassroomByTime(String week, String day, String n) {
        String actionURI = "SearchClassRoom_FromWeek_Day_Lesson"; // Action路径
        String op = "SearchClassRoom_FromWeek_Day_Lesson "; // 要调用的方法名
        Service service = new Service();
        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setUseSOAPAction(true);
            // action uri
            call.setSOAPActionURI(namespace + actionURI);
            // 设置要调用哪个方法
            call.setOperationName(new QName(namespace, op));
            call.addParameter(new QName(namespace, "week"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(namespace, "day"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(namespace, "n"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(new QName(namespace, op), String.class);
            Object[] params = new Object[]{week, day, n};
            String s = (String) call.invoke(params);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }
    }

    /**
     * 查找课表信息.
     *
     * @param studentid
     * @return
     */
    public String findClassInfo(String studentid) {
        String actionURI = "JWXX_KeChengInfo"; // Action路径
        String op = "JWXX_KeChengInfo "; // 要调用的方法名
        return findByAccount(actionURI, op, studentid);
    }

    /**
     * 查询学生成绩
     *
     * @param studentid 传入学号
     * @return 返回json格式数据, 学生的成绩信息.
     */
    public String findStudentScore(String studentid) {
        String actionURI = "JWXX_CHENGJI"; // Action路径
        String op = "JWXX_CHENGJI"; // 要调用的方法名
        return findByAccount(actionURI, op, studentid);
    }

    /**
     * 查询当前可用的空教室
     *
     * @return String类型的空教室内容.
     */
    public String findCurrentAvailableClassroom() {
        String actionURI = "SearchClass_Room_Now"; // Action路径
        String op = "SearchClass_Room_Now"; // 要调用的方法名
        Service service = new Service();
        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setUseSOAPAction(true);
            // action uri
            call.setSOAPActionURI(namespace + actionURI);
            // 设置要调用哪个方法
            call.setOperationName(new QName(namespace, op));
            // 设置返回值类型
            call.setReturnType(new QName(namespace, op), String.class);
            String s = (String) call.invoke((Object[]) null);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }
    }

    /**
     * 只需要学号即可查询的信息的通用部分
     *
     * @param actionURI 操作所在URL
     * @param op        操作类型
     * @param studentid 学号信息
     * @return 查询返回的信息
     */
    public String findByAccount(String actionURI, String op, String studentid) {
        Service service = new Service();
        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setUseSOAPAction(true);
            // action uri
            call.setSOAPActionURI(namespace + actionURI);
            // 设置要调用哪个方法
            call.setOperationName(new QName(namespace, op));
            // 设置参数名称，具体参照从浏览器中看到的
            call.addParameter(new QName(namespace, "account"), XMLType.XSD_STRING, ParameterMode.IN);
            //设置返回值
            call.setReturnType(new QName(namespace, op), String.class);
            Object[] params = new Object[]{studentid};
            String s = (String) call.invoke(params);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }
    }
}
