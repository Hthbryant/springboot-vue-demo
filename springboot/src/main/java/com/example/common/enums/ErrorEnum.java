package com.example.common.enums;

public enum ErrorEnum {

    SUCCESS("0","成功"),
    SYSTEM_ERROR("90901001","系统错误"),
    SYSTEM_BUSY("90901002","系统繁忙"),
    BAD_REQUEST("90901003","不合法请求"),
    PARAM_ERROR("90901004","参数错误"),

    //用户
    USER_NOT_EXIT("90902001","用户不存在"),
    DB_OPERATE_FAIL("90902002","操作数据库失败或无效"),
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
