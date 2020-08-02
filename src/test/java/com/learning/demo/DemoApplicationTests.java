package com.learning.demo;

import com.learning.demo.entity.Administrator;
import com.learning.demo.entity.Department;
import com.learning.demo.entity.Student;
import com.learning.demo.mapper.AdminMapper;
import com.learning.demo.mapper.DepartmentMapper;
import com.learning.demo.mapper.StudentMapper;
import org.apache.ibatis.annotations.Insert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
class DemoApplicationTests {
//
//    @Autowired
//    JavaMailSender javaMailSender;
//    @Autowired
//    StudentMapper studentMapper;
//    @Autowired
//    AdminMapper adminMapper;
//    @Autowired
//    DepartmentMapper departmentMapper;
//    @Test
//    void testStudentMapper(){
//        studentMapper.deleteStudent("1");
//
//    }
//    @Test
//    void testAdminMapper(){
////        Administrator administrator = new Administrator("account","pwd","authority");
////        adminMapper.addAdmin(new Administrator("account","pwd","authority"));
//        adminMapper.deleteAdmin("account");
//    }
//    @Test
//    void testFindAllDept(){
////        departmentMapper.addDepartment(new Department("name","des",10,10));
//        System.out.println(departmentMapper.getDepartments());
//    }
//    @Test
//    void updateDept(){
//        departmentMapper.updateDepartment(new Department(1,"name1","des1",1,1));
//    }
//    @Test
//    void deleteDept(){
//        departmentMapper.deleteDepartment(1);
//    }
//    @Test
//    void deleteStudent(){
//        studentMapper.deleteStudent("2");
//    }
//    @Test
//    void addStudent(){
//        Student student = new Student("4", "信息", "男", "贺绪清", "719424727@qq.com", "党团", "719424727", "汉", true, LocalDateTime.now());
//        studentMapper.addStudent(student);
//    }
//    @Test
//    void numberOf(){
//        System.out.println(studentMapper.numberOfRegistered("党团"));
//    }
//    @Test
//    void test(){
//        studentMapper.deleteStudent("1");
//        departmentMapper.deleteDepartment(1);
//        adminMapper.deleteAdmin("1");
//    }
//    @Test
//    void testExist(){
//        System.out.println(studentMapper.isExistStu(""));
////        System.out.println(departmentMapper.isExistDept(1));
////        System.out.println(adminMapper.isExistAdmin("1"));
//    }
//    @Test
//    void getAll(){
//        System.out.println(studentMapper.getStudents());
//        System.out.println(adminMapper.getAdmins());
//    }
//    @Test
//    void mailSender(){
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom("719424727@qq.com");
//        mailMessage.setTo("3081785468@qq.com");
//        mailMessage.setSubject("党团学新！");
//        mailMessage.setText("请加群xxxxxxxxx。");
//        javaMailSender.send(mailMessage);
//    }


}
