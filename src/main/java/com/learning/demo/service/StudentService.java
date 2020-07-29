package com.learning.demo.service;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;

import java.util.List;

public interface StudentService {

    Result addStudent(Student student);

    Result deleteStudent(String studentId);

    List<Student> getStudents();
}
