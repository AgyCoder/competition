package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/findAllUsers")
    @ResponseBody
    public List<UserModel> findAllUsers(){
        return userService.findAllUsers();
    }

}
