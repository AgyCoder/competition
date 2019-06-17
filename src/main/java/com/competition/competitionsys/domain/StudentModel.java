package com.competition.competitionsys.domain;


import java.io.Serializable;

public class StudentModel implements Serializable {

    private Integer studentId;  //学号
    private String name;     //姓名
    private String email;    //邮箱
    private Integer sex;      //性别
    private String klass;    //班级
    private String major;    //专业
    private String telephone; //电话号码


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
