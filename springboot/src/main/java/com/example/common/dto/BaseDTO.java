package com.example.common.dto;

import com.example.common.enums.ErrorEnum;

/**
 * DTO基类
 */
public class BaseDTO {

    private String code;
    private String msg;
    private String bizSeqNo;

    public BaseDTO(){

    }

    public BaseDTO(ErrorEnum errorEnum){
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
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

    public String getBizSeqNo() {
        return bizSeqNo;
    }

    public void setBizSeqNo(String bizSeqNo) {
        this.bizSeqNo = bizSeqNo;
    }
}
