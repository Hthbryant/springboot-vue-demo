package com.example.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRequestDTO extends RequestBaseDTO{

    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private Integer age;
    private String sex;
    private String address;
    private String phone;

}
