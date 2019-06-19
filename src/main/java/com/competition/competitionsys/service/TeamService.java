package com.competition.competitionsys.service;

import com.competition.competitionsys.domain.TeamInfoModel;
import com.competition.competitionsys.domain.TeamModel;
import com.competition.competitionsys.domain.VO.ResponseData;

public interface TeamService {

    ResponseData teamSignUp(TeamModel teamModel);

    ResponseData teamInfoSignUp(TeamInfoModel teamInfoModel);
}
