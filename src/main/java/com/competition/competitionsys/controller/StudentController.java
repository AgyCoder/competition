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

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private HttpServletRequest request;


    /**
     * 填写队伍信息，返回teamId
     * @param teamModel
     * @return
     */
    @RequestMapping("/teamsignup")
    public ResponseData teamSignUp(@RequestBody @Valid TeamModel teamModel){
        teamModel.setState(WebCts.WAITING);
        return teamService.teamSignUp(teamModel);
    }

    /**
     * 凭借teamId填写队友的studentId
     * @param teamInfoModel
     * @return
     */
    @RequestMapping("/teaminfosignup")
    public ResponseData teamInfoSignUp(@RequestBody TeamInfoModel teamInfoModel){
        return teamService.teamInfoSignUp(teamInfoModel);
    }


}
