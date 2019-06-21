package com.competition.competitionsys.service;

import com.competition.competitionsys.domain.Req.ReqTeamModel;
import com.competition.competitionsys.domain.TeamInfoModel;
import com.competition.competitionsys.domain.TeamModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import org.apache.ibatis.annotations.Param;

public interface TeamService {

    ResponseData teamSignUp(TeamModel teamModel);

    ResponseData teamInfoSignUp(TeamInfoModel teamInfoModel);

    ResponseData findTeamByTeamId(Integer teamId);

    ResponseData findApprovedTeam(Integer status);

    ResponseData findUnapprovedTeam(Integer status);

    ResponseData changeTeamStatus(ReqTeamModel reqTeamModel);
}
