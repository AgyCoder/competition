package com.competition.competitionsys.domain;

import java.io.Serializable;
import java.util.List;


public class TeamInfoModel implements Serializable {

    private Integer teamId;  //团队编号
    private List<StudentModel> studentModels;//队员学号


    public Integer getGroupId() {
        return teamId;
    }

    public void setGroupId(Integer groupId) {
        this.teamId = groupId;
    }


    public List<StudentModel> getStudentModels() {
        return studentModels;
    }

    public void setStudentModels(List<StudentModel> studentModels) {
        this.studentModels = studentModels;
    }
}
