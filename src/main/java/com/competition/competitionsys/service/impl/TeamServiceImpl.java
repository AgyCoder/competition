package com.competition.competitionsys.service.impl;

import com.competition.competitionsys.dao.TeamDao;
import com.competition.competitionsys.domain.Req.ReqTeamModel;
import com.competition.competitionsys.domain.TeamInfoModel;
import com.competition.competitionsys.domain.TeamModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("TeamService")
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;

    /**
     * 不管是组队还是个人都要填写队长信息，返回TeamId
     * @param teamModel
     * @return teamId
     */
    @Override
    public ResponseData teamSignUp(TeamModel teamModel) {
        Integer teamId = teamDao.teamSignUp(teamModel);
        return new ResponseData(WebCts.RESP_SUCCESS,teamId);
    }

    /**
     * 根据TeamId插入学员学号
     * @param teamInfoModel
     * @return
     */
    @Override
    @Transactional
    public ResponseData teamInfoSignUp(TeamInfoModel teamInfoModel) {
        if(teamDao.findTeamByTeamId(teamInfoModel.getTeamId())!=null) {
            if(1==teamDao.teamInfoSignUp(teamInfoModel))
                return new ResponseData(WebCts.RESP_SUCCESS, "添加学员信息成功");
            else
                return new ResponseData(WebCts.RESP_FAIL);
        }
        else
            return new ResponseData(WebCts.RESP_FAIL);
    }

    /**
     * 根据teamid查找队伍
     * @param teamId
     * @return
     */
    @Override
    public ResponseData findTeamByTeamId(Integer teamId) {
        List<TeamModel> teamModelList= (List<TeamModel>) teamDao.findTeamByTeamId(teamId);
        return new ResponseData(WebCts.RESP_SUCCESS,teamModelList);
    }

    /**
     * 查找已通过审核的队伍
     * @param status
     * @return
     */
    @Override
    public ResponseData findApprovedTeam(Integer status) {
        List<TeamModel> teamModelList= (List<TeamModel>) teamDao.findApprovedTeam(status);
        return new ResponseData(WebCts.RESP_SUCCESS,teamModelList);
    }

    /**
     * 查找未通过审核的队伍
     * @param status
     * @return
     */
    @Override
    public ResponseData findUnapprovedTeam(Integer status) {
        List<TeamModel> teamModelList= (List<TeamModel>) teamDao.findUnapprovedTeam(status);
        return new ResponseData(WebCts.RESP_SUCCESS,teamModelList);
    }

    /**
     * 根据teamid改变队伍审核状态，前台需要传入转变后的状态
     * @param reqTeamModel
     * @return
     */
    @Override
    @Transactional
    public ResponseData changeTeamStatus(ReqTeamModel reqTeamModel){
        if(1==teamDao.changeTeamStatus(reqTeamModel.getStatus(),reqTeamModel.getTeamId()))
            return new ResponseData(WebCts.RESP_SUCCESS,"修改成功");
        else
            return new ResponseData(WebCts.RESP_FAIL);
    }
}
