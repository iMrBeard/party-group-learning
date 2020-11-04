package com.learning.demo.controller;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import com.learning.demo.service.StudentService;
import com.learning.demo.util.ErrorsToMessage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "学生控制类")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ApiOperation(value = "获取报名学生列表", httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/students", produces = "application/json")
    List<Student> getStudents() {
        return studentService.getStudents();
    }

    @ApiOperation(value = "获取报名学生", httpMethod = "POST")
    @PostMapping(value = "/getStudentById")
    Result getStudentById(@RequestParam String studentId) {
        return studentService.getStudentById(studentId);
    }

    @ApiOperation(value = "学生提交报名表和一寸照片", httpMethod = "POST")
    @PostMapping(value = "/addStudent")
    Result addStudent(@Valid Student student, @ApiIgnore Errors errors, MultipartFile multipartFile) {
        if (errors.hasErrors()) {
            return Result.ofFail(ErrorsToMessage.getMessage(errors));
        } else {
            return studentService.addStudent(student, multipartFile);
        }
    }


    @ApiOperation(value = "删除报名表", httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteStudent")
    Result deleteStudents(@RequestParam String studentId) {
        return studentService.deleteStudent(studentId);
    }
}
