package com.internet.jiaowuxitong.common.utils;

import javax.servlet.http.HttpSession;


public class SessionUtils {
    /**
     * protected :是在同一个包下才可以访问
     * valueof : valueOf()可以把基本类型或者String类型，转换为包装类对象
     * @param session
     * @return
     */
    public final static  Integer getStudentIdFromSession(HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("studentId").toString());
        return uid;
    }
    public final static  String getAdminIdFromSession(HttpSession session){
        String adminId = session.getAttribute("adminId").toString();
        return adminId;
    }
    public final static  String getNameFromSession(HttpSession session){
        return session.getAttribute("name").toString();
    }
}
