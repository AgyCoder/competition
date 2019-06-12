package com.competition.competitionsys.service;

import com.competition.competitionsys.domain.UserModel;

import java.util.List;

public interface UserService {
    public List<UserModel> findAllUsers();
}
