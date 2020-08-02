package com.learning.demo.service.Impl;

import com.learning.demo.entity.Department;
import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import com.learning.demo.mapper.DepartmentMapper;
import com.learning.demo.mapper.StudentMapper;
import com.learning.demo.service.DepartmentService;
import com.learning.demo.service.MailService;
import com.learning.demo.service.StudentService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    MailService mailService;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Result addStudent(Student student) {
        Department department = departmentMapper.isExistDept(student.getDepartmentName());
        if (studentMapper.isExistStu(student.getStudentId()) != null)
            return Result.ofFail("你已经报名成功！无需再次报名");
        student.setRegisteredAt(LocalDateTime.now());
        if (department.getRemaining() == 0)
            return Result.ofFail("该部门报名人数已达上限");
        if (studentMapper.addStudent(student) == 1) {
            department.setRemaining(department.getRemaining() - 1);
            departmentMapper.updateDepartment(department);
            mailService.sendSimpleMail("1923161393@qq.com", student.getEmail(), "content");

            return Result.ofSuccess("报名成功！");
        } else {
            return Result.ofFail("报名失败！");
        }
    }

    @Override
    public Result deleteStudent(String studentId) {
        Department department = departmentMapper.isExistDept(studentMapper.isExistStu(studentId).getDepartmentName());
        if (studentMapper.deleteStudent(studentId) == 1) {
            department.setRemaining(department.getRemaining() + 1);
            departmentMapper.updateDepartment(department);
            return Result.ofSuccess("删除学生成功！");
        } else
            return Result.ofFail("删除学生失败！");
    }

    @Override
    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }
}
