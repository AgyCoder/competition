package com.competition.competitionsys.service.impl;

import com.competition.competitionsys.dao.UserDao;
import com.competition.competitionsys.domain.Req.ReqUserModel;
import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    /**
     * 登录验证
     * @param reqUserModel
     * @return对应的用户权限
     */
    public ResponseData login(ReqUserModel reqUserModel){
            //根据用户码查找用户
            UserModel userModel = (UserModel) userService.findUserByUserCode(reqUserModel.getUserCode()).getData();
            //判断用户是否存在
            if (null != userModel) {
                //判断密码
                if (userModel.getPassword().equals(reqUserModel.getPassword())) {
                    //返回权限
                    session.setAttribute(WebCts.SESSION_USER,userModel);
                    return new ResponseData(WebCts.RESP_SUCCESS,userModel.getRole());
                } else
                    return new ResponseData("密码错误");
            }
            return new ResponseData("用户不存在");
    }

    /**
     * 查看所有用户
     * @return 用户列表
     */
    @Override
    public ResponseData findAllUsers() {
        List<UserModel> userModelList = userDao.findAllUsers();
        return new ResponseData(WebCts.RESP_SUCCESS,userModelList);
    }

    /**
     * 通过用户码查找用户
     * @param userCode
     * @return对应的用户
     */
    @Override
    public ResponseData findUserByUserCode(Integer userCode) {
        UserModel userModel = userDao.findUserByUserCode(userCode);
        return new ResponseData(WebCts.RESP_SUCCESS,userModel);
    }

}
