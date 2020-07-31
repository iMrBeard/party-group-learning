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
import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    DepartmentMapper departmentMapper;

//    @Test
//    void testStudentMapper(){
//        Student student = new Student("4", "计科", "男", "吴义虎", "1726036835@qq.com", "党团", "719424727", "汉","好看" ,"456",true,new Date());
//        Student student2 = new Student("1", "计科", "男", "吴义虎", "1726036835@qq.com", "党团", "719424727", "汉", "帅气","123",true,new Date());
//        studentMapper.addStudent(student);
//        studentMapper.addStudent(student2);
//        studentMapper.deleteStudent("1");
//        studentMapper.deleteStudent("4");
//        System.out.println(studentMapper.isExistStu("4"));
//        System.out.println(studentMapper.getStudents());
//    }

//    @Test
//    void testAdminMapper(){
//        adminMapper.addAdmin(new Administrator("account1","pwd","authority"));
//        adminMapper.addAdmin(new Administrator("account2","pwd","authority"));
//
//        System.out.println(adminMapper.getAdmins());
//
//        adminMapper.deleteAdmin("account1");
//        adminMapper.deleteAdmin("account2");
//    }

//    @Test
//    void  testDepartmentMapper(){
//        Department department=new Department(101,"信息","好",30,60);
//        Department department1=new Department(101,"信息","好",20,60);
//
//        departmentMapper.addDepartment(department);
//
//        System.out.println(departmentMapper.getDepartments());
//
//        departmentMapper.updateDepartment(department1);
//        System.out.println(departmentMapper.getDepartments());
//
//        departmentMapper.deleteDepartment(101);
//    }

/*
    @Test
    void testFindAllDept(){
//        departmentMapper.addDepartment(new Department("name","des",10,10));
        System.out.println(departmentMapper.getDepartments());
    }
    @Test
    void updateDept(){
        departmentMapper.updateDepartment(new Department(1,"name1","des1",1,1));
    }
    @Test
    void deleteDept(){
        departmentMapper.deleteDepartment(1);
    }
    @Test
    void deleteStudent(){
        studentMapper.deleteStudent("2");
    }
    @Test
    void addStudent(){
        Student student = new Student("4", "信息", "男", "贺绪清", "719424727@qq.com", "党团", "719424727", "汉", "大哥",true,new Date());
        studentMapper.addStudent(student);
    }
    @Test
    void test(){
        studentMapper.deleteStudent("1");
        departmentMapper.deleteDepartment(1);
        adminMapper.deleteAdmin("1");
    }
    @Test
    void testExist(){
        System.out.println(studentMapper.isExistStu(""));
//        System.out.println(departmentMapper.isExistDept(1));
//        System.out.println(adminMapper.isExistAdmin("1"));
    }
    @Test
    void getAll(){
        System.out.println(studentMapper.getStudents());
        System.out.println(adminMapper.getAdmins());
    }
    @Test
    void mailSender(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("719424727@qq.com");
        mailMessage.setTo("3081785468@qq.com");
        mailMessage.setSubject("党团学新！");
        mailMessage.setText("请加群xxxxxxxxx。");
        javaMailSender.send(mailMessage);
    }

    */

}
