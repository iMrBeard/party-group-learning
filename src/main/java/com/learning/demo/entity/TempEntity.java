package com.learning.demo.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TempEntity {
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

    @NotBlank(message = "请输入部门名称！")
    private String departmentName;

    @NotBlank(message = "请输入QQ！")
    private String qqNumber;

    @NotBlank(message = "请填写民族！")
    private String nation;

    @NotBlank(message = "请输入个人简介！")
    private String description;

    private boolean adjustable;

    @NotNull
    private MultipartFile file;

    public Student getStudent(){
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
    public MultipartFile getMultipartFile(){
        return file;
    }
}
