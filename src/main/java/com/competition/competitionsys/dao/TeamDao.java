package com.competition.competitionsys.dao;

import com.competition.competitionsys.domain.TeamInfoModel;
import com.competition.competitionsys.domain.TeamModel;

public interface TeamDao {

    Integer teamSignUp (TeamModel teamModel);

    Integer teamInfoSignUp(TeamInfoModel teamInfoModel);
}
