package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 咕噜科
 * ClassName: RedisDTO
 * date: 2021/8/30 1:37
 * Description:
 * version 1.0
 */
@Data
public class RedisDTO implements Serializable {

    private String key;
    private String value;

}
