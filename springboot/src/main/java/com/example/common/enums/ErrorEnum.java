package com.example.common.enums;

public enum ErrorEnum {

    SUCCESS("0","成功"),
    SYSTEM_ERROR("1001","系统错误"),
    SYSTEM_BUSY("1002","系统繁忙"),
    BAD_REQUEST("1003","不合法请求"),

    //用户
    USER_NOT_EXIT("2001","用户不存在"),
    ;

    ErrorEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

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
}
