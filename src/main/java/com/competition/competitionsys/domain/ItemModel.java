package com.competition.competitionsys.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
* 竞赛项目实体类
*
* */

public class ItemModel implements Serializable {

    private Integer id;       //项目id
    private String itemName;     //项目名称
    private Integer categoryId;  //类别id
    private String categoryName;//类别名称
    private String photo;        //图片
    private String description;  //项目描述
    private String signUpStartTime; //比赛报名时间
    private String signUpEndTime;   //比赛报名结束
    private String startTime;       //比赛开始时间
    private String endTime;         //比赛结束时间
    private String sponsor;         //主办方
    private Integer teacherId;    //教师工号

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank(message = "比赛名称不能为空")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @NotNull(message = "请填写比赛种类")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSignUpStartTime() {
        return signUpStartTime;
    }

    public void setSignUpStartTime(String signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public String getSignUpEndTime() {
        return signUpEndTime;
    }

    public void setSignUpEndTime(String signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", signUpStartTime='" + signUpStartTime + '\'' +
                ", signUpEndTime='" + signUpEndTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}
