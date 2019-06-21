package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.Req.ReqUserModel;
import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*",
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.PUT})
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private HttpSession session;



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
        return userService.findStudentByUserCode(userCode);
    }

    @RequestMapping("/changePassword")
    public ResponseData ChangePassword(@RequestParam(name = "password" )String pd){

        System.out.println(session.getAttribute(WebCts.SESSION_USER));
        UserModel reqUserModel= (UserModel) session.getAttribute(WebCts.SESSION_USER);

        reqUserModel.setPassword(pd);
        //更改数据库密码
        userService.updatePassword(reqUserModel.getUserCode(),reqUserModel.getPassword());
        //更新session密码
        session.setAttribute(WebCts.SESSION_USER,reqUserModel);
        System.out.println(reqUserModel);

        return new ResponseData(WebCts.RESP_SUCCESS);
    }


}
