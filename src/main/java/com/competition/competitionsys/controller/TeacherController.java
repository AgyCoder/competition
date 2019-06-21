package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.Req.ReqTeamModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/teacher")
@RestController
@CrossOrigin(origins="*",
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.PUT})
public class TeacherController {
    @Autowired
    private TeamService teamService;

    @RequestMapping("/findUnapprovedTeam/{status}")
    public ResponseData findUnapprovedTeam(@PathVariable("status")Integer status){
        return teamService.findUnapprovedTeam(status);
    }

    @RequestMapping("/findApprovedTeam/{id}")
    public ResponseData findApprovedTeam(@PathVariable("status")Integer status){
        return teamService.findApprovedTeam(status);
    }

    @RequestMapping("/changeTeamStatus")
    public ResponseData changeTeamStatus(@RequestBody ReqTeamModel reqTeamModel){
        return teamService.changeTeamStatus(reqTeamModel);
    }

    @RequestMapping("/findTeamByTeamId/{teamId}")
    public ResponseData findTeamByTeamId(@PathVariable("teamId")Integer teamId){
        return teamService.findTeamByTeamId(teamId);
    }


}
