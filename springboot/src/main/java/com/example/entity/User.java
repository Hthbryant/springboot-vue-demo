package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class User {

    @TableId(value = "id",type = IdType.AUTO)

    //用户id
    private int id;
    //用户名
    private String username;
    //用户密码
    private String password;
    //用户昵称
    private String nickName;
    //用户地址
    private String address;
    //年龄
    private int age;
    //性别
    private String sex;
    //电话
    private String phone;

}
