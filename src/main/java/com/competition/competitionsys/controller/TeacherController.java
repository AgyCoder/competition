package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.Req.ReqTeamModel;
import com.competition.competitionsys.domain.Req.ReqUserModel;
import com.competition.competitionsys.domain.TeacherModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.TeamService;
import com.competition.competitionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/teacher")
@RestController
@CrossOrigin(origins="*",
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.PUT})
public class TeacherController {
    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private HttpSession session;

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

    /**
     * 修改老师个人信息
     * @param teacherModel
     * @return
     */
    @RequestMapping("/updateInfo")
    public ResponseData updateInfo(@RequestBody TeacherModel teacherModel){
        ReqUserModel reqUserModel = (ReqUserModel) session.getAttribute(WebCts.SESSION_USER);
        teacherModel.setTeacherId(reqUserModel.getUserCode());
        return userService.updateTeacherInfo(teacherModel);
    }

}
