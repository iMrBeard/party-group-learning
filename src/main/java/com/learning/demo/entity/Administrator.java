package com.learning.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@ApiModel("管理员")
public class Administrator {

    @ApiModelProperty("账户")
    private String account;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("权限")
    private String authority;
}
