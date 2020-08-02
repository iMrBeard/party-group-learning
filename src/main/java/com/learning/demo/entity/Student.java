package com.learning.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学生")
public class Student {

    @ApiModelProperty("学生id")
    @NotBlank
    @Size(min = 13,max = 13,message = "请填写学号！")
    private String studentId;

    @ApiModelProperty("学生班级")
    @NotBlank(message = "请填写班级！")
    private String className;

    @ApiModelProperty("学生性别")
    @NotBlank
    private String gender;

    @ApiModelProperty("学生姓名")
    @NotBlank(message = "请填写姓名！")
    private String realName;

    @ApiModelProperty("学生email")
    @Email(message = "请输入正确的Email地址！")
    private String email;

    @ApiModelProperty("学生报名部门名称")
    private String departmentName;

    @ApiModelProperty("学生qq")
    @NotBlank(message = "请输入QQ！")
    private String qqNumber;

    @ApiModelProperty("学生民族")
    @NotBlank(message = "请填写民族！")
    private String nation;

    @ApiModelProperty("学生简介")
    @NotBlank(message = "请输入个人简介！")
    private String description;

    @ApiModelProperty("学生头像")
    private String avatar;

    @ApiModelProperty("是否接受调剂")
    private boolean adjustable;

    @ApiModelProperty("注册时间")
    private LocalDateTime registeredAt;

}
