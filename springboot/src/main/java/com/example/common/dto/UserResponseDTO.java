package com.example.common.dto;

import com.example.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserResponseDTO extends ResponseBaseDTO{

    private List<User> userList;

}
