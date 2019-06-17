package com.competition.competitionsys.domain.Req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 该类专门用来接受请求参数
 * 同时可以提高一定的系统安全性
 */
public class ReqUserModel {
    private Integer userCode;//用户码(职工号或学号)
    private String password;//密码


    @NotNull(message="职工号不能为空")
    public Integer getUserCode() {
        return userCode;
    }
    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    @NotBlank(message="密码不能为空")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ReqUserModel{" +
                "userCode=" + userCode +
                ", password='" + password + '\'' +
                '}';
    }
}
