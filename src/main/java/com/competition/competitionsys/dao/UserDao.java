package com.competition.competitionsys.dao;

import com.competition.competitionsys.domain.StudentModel;
import com.competition.competitionsys.domain.TeacherModel;
import com.competition.competitionsys.domain.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {

    //用户登录
    UserModel login(@Param("userCode")Integer userCode, @Param("password")String password);

    //查找所有登录用户
    List<UserModel> findAllUsers();

    //根据userCode寻找学生
    StudentModel findStudentByUserCode(Integer userCode);

    //根据userCode寻找老师
    TeacherModel findTeacherByUserCode(Integer userCode);

    void updatePassword(int userId, String password);
}
