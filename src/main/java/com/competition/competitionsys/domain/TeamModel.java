package com.competition.competitionsys.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class TeamModel implements Serializable {

    private Integer studentId;     //报名人id
    private Integer itemId;     //比赛项目id
    private String teacherName; //指导老师姓名
    private Integer teamRole;   //0是个人,1是团体
    private Integer status;      //审核状态0待审核，1通过，2未通过
    private Integer teammateId;   //队友学号

    public Integer getTeammateId() {
        return teammateId;
    }

    public void setTeammateId(Integer teammateId) {
        this.teammateId = teammateId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @NotNull(message = "请填写学号")
    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(Integer teamRole) {
        this.teamRole = teamRole;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TeamModel{" +
                "studentId=" + studentId +
                ", itemId=" + itemId +
                ", teacherName='" + teacherName + '\'' +
                ", teamRole=" + teamRole +
                ", status=" + status +
                ", teammateId=" + teammateId +
                '}';
    }
}
