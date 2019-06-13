package com.competition.competitionsys.domain.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.competition.competitionsys.domain.WebCts;

import java.io.Serializable;

public class ResponseData implements Serializable{
    private String msg;//传递执行结果，成功或者失败
    private Object data;//返回给前端的数据

    public ResponseData(String msg){
        this.msg=msg;
    }

    public ResponseData(String msg, Object data){
        this(msg);
        //this.msg=msg;
        this.data=data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



}
