package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.Req.ReqUserModel;
import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData login(@RequestBody @Valid ReqUserModel reqUserModel){
        if(null!=reqUserModel) {
            //根据用户码查找用户
            UserModel userModel = userService.findUserByUserCode(reqUserModel.getUserCode());
            //判断用户是否存在
            if (null != userModel) {
                //判断密码
                if (userModel.getPassword().equals(reqUserModel.getPassword())) {
                    //判断角色
                    if (userModel.getRole().equals(reqUserModel.getRole())) {
                        if(userModel.getRole()==1){
                            System.out.println("欢迎学生");
                            return new ResponseData(WebCts.RESP_SUCCESS);
                        }else
                            System.out.println("欢迎老师");
                            return new ResponseData(WebCts.RESP_SUCCESS);
                    } else
                        return new ResponseData("角色不符");
                } else
                    return new ResponseData("密码错误");
            }
            return new ResponseData("用户不存在");
        }
        return new ResponseData("网络出错！！！");
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        session.invalidate();
        System.out.println("请重新登录");
        return "login.html";
    }

}
