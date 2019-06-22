package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*",
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.PUT})
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 找所有用户
     * @return
     */
    @RequestMapping("/findAllUsers")
    public ResponseData findAllUsers(){
        return userService.findAllUsers();
    }


    /**
     * 找学生
     * @param userCode
     * @return
     */
    @RequestMapping("/findStudent/{userCode}")
    public ResponseData findStudent(@PathVariable("userCode") Integer userCode){
        return userService.findStudentByUserCode(userCode);
    }

    /**
     * 找老师
     * @param userCode
     * @return
     */
    @RequestMapping("/findTeacher/{userCode}")
    public ResponseData findTeacher(@PathVariable("userCode") Integer userCode){
        return userService.findTeacherByUserCode(userCode);
    }



}
