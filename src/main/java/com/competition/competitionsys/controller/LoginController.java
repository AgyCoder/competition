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
@RestController
@CrossOrigin(origins="*",
            allowCredentials = "true",
            allowedHeaders = "*",
            methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.PUT})
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseData login(@RequestBody @Valid ReqUserModel reqUserModel){
        System.out.println(reqUserModel);
        if(null != reqUserModel) {
            session.setAttribute(WebCts.SESSION_USER,reqUserModel);
//            System.out.println(session.getAttribute(WebCts.SESSION_USER));
//            String id=session.getId();
//            System.out.println(id);
            return userService.login(reqUserModel);
        }else
            return new ResponseData("网络错误");
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        session.invalidate();
        System.out.println("请重新登录");
        return "login.html";
    }

}
