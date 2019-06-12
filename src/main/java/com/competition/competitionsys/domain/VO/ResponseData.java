package com.competition.competitionsys.domain.VO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.competition.competitionsys.domain.WebCts;

import java.io.Serializable;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
// 保证序列化 json 的时候，如果是 null 的对象，key 也会消失
public class ResponseData implements Serializable {
    private String msg;//传递执行结果，成功或者失败
    private Object data;//返回给前端的数据

    private ResponseData(String msg){
        this.msg=msg;
    }
    //返回成功的消息
    public static ResponseData createBySuccess(){
        return new ResponseData(WebCts.RESP_SUCCESS);
    }
    //返回失败消息
    public static ResponseData createByFail(){
        return new ResponseData(WebCts.RESP_FAIL);
    }
}
