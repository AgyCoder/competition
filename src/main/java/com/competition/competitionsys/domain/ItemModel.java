package com.competition.competitionsys.domain;

import java.io.Serializable;

/*
* 竞赛项目实体类
*
* */

public class ItemModel implements Serializable {

    private Integer id;       //项目id
    private String itemName;     //项目名称
    private Integer categoryId;  //类别id
    private String photo;        //图片
    private String description;  //项目描述
    private String signUpStartTime; //比赛报名时间
    private String signUpEndTime;   //比赛报名结束
    private String startTime;       //比赛开始时间
    private String endTime;         //比赛结束时间
    private String sponsor;         //主办方

    public Integer getItemId() {
        return id;
    }

    public void setItemId(Integer itemId) {
        this.id = itemId;
    }

    public String getItemname() {
        return itemName;
    }

    public void setItemname(String itemname) {
        this.itemName = itemname;
    }

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "itemId=" + id +
                ", itemName='" + itemName + '\'' +
                ", categoryId=" + categoryId +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", signUpStartTime='" + signUpStartTime + '\'' +
                ", signUpEndTime='" + signUpEndTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", sponsor='" + sponsor + '\'' +
                '}';
    }
}
