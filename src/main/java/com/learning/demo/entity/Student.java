package com.learning.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotBlank
    @Size(min = 13,max = 13,message = "请填写学号！")
    private String studentId;

    @NotBlank(message = "请填写班级！")
    private String className;

    @NotBlank
    private String gender;

    @NotBlank(message = "请填写姓名！")
    private String realName;

    @Email(message = "请输入正确的Email地址！")
    private String email;

    private String departmentName;

    @NotBlank(message = "请输入QQ！")
    private String qqNumber;

    @NotBlank(message = "请填写民族！")
    private String nation;

    @NotBlank(message = "请输入个人简介！")
    private String description;

    private String avatar;

    private boolean adjustable;

    private LocalDateTime registeredAt;


}
