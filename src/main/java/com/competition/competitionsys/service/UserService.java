package com.competition.competitionsys.service;

import com.competition.competitionsys.domain.Req.ReqUserModel;
import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.domain.VO.ResponseData;

import java.util.List;

public interface UserService {
    //查找所有登录用户
    ResponseData findAllUsers();

    //根据userCode寻找学生
    ResponseData findStudentByUserCode(Integer userCode);

    //根据userCode寻找老师
    ResponseData findTeacherByUserCode(Integer userCode);

    //验证登录
    ResponseData login(ReqUserModel reqUserModel);
}
