package com.example.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRequestDTO extends RequestBaseDTO{

    private int id;
    private String userId;
    private String username;
    private String password;
    private String nickName;
    private String address;
    private String phone;

}
