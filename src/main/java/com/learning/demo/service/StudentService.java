package com.learning.demo.service;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    Result addStudent(Student student, MultipartFile file);

    Result deleteStudent(String studentId);

    Result getStudentById(String studentId);

    List<Student> getStudents();
}
