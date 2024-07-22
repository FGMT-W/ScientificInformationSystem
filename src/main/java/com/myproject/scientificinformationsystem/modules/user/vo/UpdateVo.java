package com.myproject.scientificinformationsystem.modules.user.vo;

import lombok.Data;


@Data
public class UpdateVo {

    private Integer id;
    private String account;
    private String password;
    private String name;
}
