package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/findAllUsers")
    public ResponseData findAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping("/findStudent/{userCode}")
    public ResponseData findStudent(@PathVariable("userCode") Integer userCode){
        return userService.findStudentByUserCode(userCode);
    }

    @RequestMapping("/findTeacher/{userCode}")
    public ResponseData findTeacher(@PathVariable("userCode") Integer userCode){
        return userService.findStudentByUserCode(userCode);
    }
}
