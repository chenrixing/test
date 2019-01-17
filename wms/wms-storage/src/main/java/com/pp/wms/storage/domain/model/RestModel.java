package com.pp.wms.storage.domain.model;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Makkah at 2019/1/16 10:41
 */
@ApiModel(value = "Restful数据返回结构")
public class RestModel<T> implements Serializable {
    @ApiModelProperty(value = "状态码")
    private int status;
    @ApiModelProperty(value = "调用结果")
    private String msg;
    @ApiModelProperty(value = "返回结果集")
    private T data;

    public RestModel(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
//        final StringBuilder sb = new StringBuilder("{");
//        sb.append("\"status\":\"")
//                .append(status).append('\"');
//        sb.append(",\"msg\":\"")
//                .append(msg).append('\"');
//        sb.append(",\"data\":")
//                .append(JSON.toJSONString(data));
//        sb.append('}');
//        return sb.toString();
        return JSON.toJSONString(this);
    }
}
