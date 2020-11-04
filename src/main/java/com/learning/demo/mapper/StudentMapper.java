package com.learning.demo.mapper;

import com.learning.demo.entity.Student;

import java.util.List;


public interface StudentMapper {

    List<Student> getStudents();

    int addStudent(Student student);

    int deleteStudent(String studentId);

    Student isExistStu(String studentId);

    int numberOfRegistered(String departmentName);

    Student getStudentById(String studentId);

}
