package com.competition.competitionsys.dao;

import com.competition.competitionsys.domain.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {

    //查找所有登录用户
    public List<UserModel> findAllUsers();

    //根据userCode寻找用户
    public UserModel findUserByUserCode(Integer userCode);
}
