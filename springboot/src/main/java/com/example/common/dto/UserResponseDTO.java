package com.example.common.dto;

import com.example.common.enums.ErrorEnum;
import com.example.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserResponseDTO extends ResponseBaseDTO{

    private User user;

    private List<User> userList;

    public UserResponseDTO(ErrorEnum errorEnum){
        super(errorEnum);
    }

}
