package com.energy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    //姓名
    private String name;

    //账号
    private String username;

    //密码
    private String password;

    //手机号
    private String phone;

    //性别 0 女 1 男
    private String preferences;

    //身份证号
    private String number;

    //头像
    private String avatar;

    //描述
    private String description;

    //用户状态 0禁 1起
    private Integer status;

    //注册时间
    private LocalDateTime createTime;
}
