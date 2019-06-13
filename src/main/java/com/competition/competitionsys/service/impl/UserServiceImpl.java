package com.competition.competitionsys.service.impl;

import com.competition.competitionsys.dao.UserDao;
import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserModel> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public UserModel findUserByUserCode(Integer userCode) {
        return userDao.findUserByUserCode(userCode);
    }
}
