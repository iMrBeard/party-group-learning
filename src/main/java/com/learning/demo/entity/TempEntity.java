package com.learning.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Data
@ApiModel("负责学生报名时报名信息和照片接收")
public class TempEntity {

    @ApiModelProperty("学号")
    @NotBlank
    @Size(min = 13, max = 13, message = "请填写学号！")
    private String studentId;

    @ApiModelProperty("班级")
    @NotBlank(message = "请填写班级！")
    private String className;

    @ApiModelProperty("性别")
    @NotBlank
    private String gender;

    @ApiModelProperty("姓名")
    @NotBlank(message = "请填写姓名！")
    private String realName;

    @ApiModelProperty("邮件地址")
    @Email(message = "请输入正确的Email地址！")
    private String email;

    @ApiModelProperty("想加入的部门名称")
    @NotBlank(message = "请输入部门名称！")
    private String departmentName;

    @ApiModelProperty("QQ号")
    @NotBlank(message = "请输入QQ！")
    private String qqNumber;

    @ApiModelProperty("民族")
    @NotBlank(message = "请填写民族！")
    private String nation;

    @ApiModelProperty("个人简介")
    @NotBlank(message = "请输入个人简介！")
    private String description;

    @ApiModelProperty("是否接受调动")
    private boolean adjustable;

    @ApiModelProperty("照片")
    @NotNull
    private MultipartFile file;


    public Student getStudent() {
        Student student = new Student();
        student.setClassName(className);
        student.setGender(gender);
        student.setNation(nation);
        student.setRealName(realName);
        student.setEmail(email);
        student.setQqNumber(qqNumber);
        student.setDepartmentName(departmentName);
        student.setDescription(description);
        student.setAdjustable(adjustable);
        student.setStudentId(studentId);
        return student;
    }

    public MultipartFile getMultipartFile() {
        return file;
    }
}
