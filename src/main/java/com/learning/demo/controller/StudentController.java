package com.learning.demo.controller;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import com.learning.demo.entity.TempEntity;
import com.learning.demo.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "学生控制类")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ApiOperation(value = "获取报名学生列表",httpMethod = "GET",produces = "application/json")
    @GetMapping(value = "/students",produces = "application/json")
    List<Student> getStudents(){
        return studentService.getStudents();
    }

    @ApiOperation(value = "学生提交报名表和一寸照片",httpMethod = "POST",produces = "multipart/form-data")
    @PostMapping(value = "/addStudent")
    Result addStudent(TempEntity tempEntity){
        return studentService.addStudent(tempEntity.getStudent(),tempEntity.getFile());
    }


    @ApiOperation(value = "删除报名表",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteStudent/{studentId}")
    Result deleteStudents(@PathVariable String studentId){
        return studentService.deleteStudent(studentId);
    }
}
