package com.competition.competitionsys.service;

import com.competition.competitionsys.domain.UserModel;

import java.util.List;

public interface UserService {
    //查找所有登录用户
    public List<UserModel> findAllUsers();

    //根据userCode寻找用户
    public UserModel findUserByUserCode(Integer userCode);
}
