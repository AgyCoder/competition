package com.competition.competitionsys.controller;


import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.TeamInfoModel;
import com.competition.competitionsys.domain.TeamModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;

@RequestMapping("/signup")
@RestController
public class SignUpController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private HttpServletRequest request;


    @RequestMapping("/teamsignup")
    public String teamSignUp(@RequestBody @Valid TeamModel teamModel){

//        TeamModel teamModel =new TeamModel();
//        teamModel.setState(WebCts.WAITING);
//        teamModel.setStudentId((Integer)teamMap.get("studentId"));
//        teamModel.setTeacherName((String)teamMap.get("teacherName"));
//        teamModel.setItemId((Integer)teamMap.get("iteamId"));
        //调试用
        System.out.println(teamModel.getStudentId());

        if(WebCts.TEAM_SINGLE==teamModel.getTeamRole()) {
            return teamService.teamSignUp(teamModel).toString();
        } else {
            teamService.teamSignUp(teamModel);
            Integer teamId = teamModel.getItemId();
            TeamInfoModel teamInfoModel =new TeamInfoModel();
            teamInfoModel.setGroupId(teamId);
            request.setAttribute("",teamId);
            return "forward:/teamInfoSignUp";
        }
    }

//    @RequestMapping("/teaminfosignup")
//    public ResponseData teamInfoSignUp(@RequestBody)


}
