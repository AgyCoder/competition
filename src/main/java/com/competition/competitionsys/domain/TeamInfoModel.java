package com.competition.competitionsys.domain;

import java.io.Serializable;
import java.util.List;


public class TeamInfoModel implements Serializable {

    private Integer teamId;  //团队编号
    private List<Integer> studentId;//队员学号


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer groupId) {
        this.teamId = teamId;
    }

    public List<Integer> getStudentId() {
        return studentId;
    }

    public void setStudentId(List<Integer> studentId) {
        this.studentId = studentId;
    }
}
