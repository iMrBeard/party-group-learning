package com.learning.demo.service.Impl;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import com.learning.demo.mapper.StudentMapper;
import com.learning.demo.service.MailService;
import com.learning.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    MailService mailService;
    @Override
    public Result addStudent(Student student) {
        if(studentMapper.isExistStu(student.getStudentId())!=null)
            return Result.ofFail("你已经报名成功！无需再次报名");
        if(studentMapper.addStudent(student) == 1){
            mailService.sendSimpleMail("719424727@qq.com", student.getEmail(), "content");
            return Result.ofSuccess("报名成功！");
        } else {
            return Result.ofFail("报名失败！");
        }
    }

    @Override
    public Result deleteStudent(String studentId) {
        if(studentMapper.deleteStudent(studentId) == 1)
            return Result.ofSuccess("删除学生成功！");
        else
            return Result.ofFail("删除学生失败！");
    }

    @Override
    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }
}
