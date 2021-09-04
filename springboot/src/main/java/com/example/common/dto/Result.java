package com.example.common.dto;

import com.example.common.enums.ErrorEnum;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Result {

    private String code = "0";
    private String msg = "success";
    private String responseTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private BaseDTO data;

    public Result() {

    }

    public Result(ErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
    }

    public Result(BaseDTO data) {
        this.code = data.getCode();
        this.msg = data.getMsg();
        data.setCode(null);
        data.setMsg(null);
        if ("0".equals(this.code)) {
            this.data = data;
        }
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseDTO getData() {
        return data;
    }

    public void setData(BaseDTO data) {
        this.data = data;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }
}
