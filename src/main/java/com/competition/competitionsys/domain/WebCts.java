package com.competition.competitionsys.domain;

public class WebCts {
    public static int ROLE_STUDENT=1;//学生角色
    public static int ROLE_TEACHER=0;//老师角色

    public static int SEX_MAN=1;    //男
    public static int SEX_WOMEN=2;   //女

    public static int WAITING=0;   //等待审核
    public static int APPROVED=1;   //通过
    public static int UNAPPROVED=2; //没有通过

    public static int TEAM_SINGLE=0;//个人
    public static int TEAM_MULTI=1;//团队

    public static String SESSION_USER="user";
    //public static int ROLE_ACTIVE=1;//角色激活
    //public static int ROLE_INACTIVE=0;//角色停用


    //服务器端响应
    public static String RESP_SUCCESS ="success";
    public static String RESP_FAIL="fail";


}
