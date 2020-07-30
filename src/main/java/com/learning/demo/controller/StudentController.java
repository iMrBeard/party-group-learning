package com.learning.demo.controller;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import com.learning.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students",produces = "application/json")
    List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping(value = "/addStudent")
    Result addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @DeleteMapping(value = "/deleteStudent")
    Result deleteStudents(String studentId){
        return studentService.deleteStudent(studentId);
    }
}
