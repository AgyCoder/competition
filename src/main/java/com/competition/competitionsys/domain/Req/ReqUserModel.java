package com.competition.competitionsys.domain.Req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 该类专门用来接受请求参数
 */
public class ReqUserModel {
    private Integer userCode;//用户码(职工号或学号)
    private String password;//密码
    private Integer role;  //0是老师，1是学生

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
