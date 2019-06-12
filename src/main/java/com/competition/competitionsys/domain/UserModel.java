package com.competition.competitionsys.domain;

import java.io.Serializable;

/*
* 用户实体类
*
* */

public class UserModel implements Serializable {
    private Integer id;
    private Integer userCode;//用户码(职工号或学号)
    private String password;//密码
    private Integer role;  //0是老师，1是学生

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", userCode=" + userCode +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
