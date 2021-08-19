package com.example.common.dto;

import com.example.common.enums.ErrorEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseBaseDTO extends BaseDTO{

    private String code = "0";
    private String msg = "success";

    public ResponseBaseDTO(){

    }

    public ResponseBaseDTO(ErrorEnum errorEnum){
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
    }

}
