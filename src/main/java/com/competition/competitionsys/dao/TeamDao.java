//package com.competition.competitionsys.dao;
//
//import com.competition.competitionsys.domain.TeamInfoModel;
//import com.competition.competitionsys.domain.TeamModel;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//
//@Mapper
//public interface TeamDao {
//
//    Integer teamSignUp (TeamModel teamModel);
//
//    Integer teamInfoSignUp(TeamInfoModel teamInfoModel);
//
//    TeamModel findTeamByTeamId(Integer teamId);
//
//    TeamModel findApprovedTeam(Integer status);
//
//    TeamModel findUnapprovedTeam(Integer status);
//
//    Integer changeTeamStatus(@Param("status")Integer status,@Param("teamId")Integer teamId);
//}
