package com.competition.competitionsys.service.impl;

import com.competition.competitionsys.dao.TeamDao;
import com.competition.competitionsys.domain.TeamInfoModel;
import com.competition.competitionsys.domain.TeamModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TeamService")
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;

    @Override
    public ResponseData teamSignUp(TeamModel teamModel) {
        Integer teamId = teamDao.teamSignUp(teamModel);
        return new ResponseData(WebCts.RESP_SUCCESS,teamId);
    }

    @Override
    public ResponseData teamInfoSignUp(TeamInfoModel teamInfoModel) {
        return null;
    }
}
