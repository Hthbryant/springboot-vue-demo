package com.example.common.dto;

import com.example.common.enums.ErrorEnum;

public class Result<T> {

    private String code = "0";
    private String msg = "success";
    private T data;

    public Result(){

    }

    public Result(ErrorEnum errorEnum){
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
    }

    public Result(T data){
        this.code = "0";
        this.msg = "success";
        this.data = data;
    }

    public Result(String code,String msg){
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
