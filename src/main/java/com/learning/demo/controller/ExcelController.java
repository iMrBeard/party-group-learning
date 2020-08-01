package com.learning.demo.controller;

import com.learning.demo.entity.Result;
import com.learning.demo.service.ExcelService;
import com.learning.demo.service.Impl.ExcelServiceImpl;
import com.learning.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/excel")
public class ExcelController {

    ExcelServiceImpl excel = new ExcelServiceImpl();
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/download")
    public Result download() throws IOException {
        String headers[] = {"姓名", "性别", "班级", "意向部门", "民族", "QQ", "邮箱", "自我描述", "是否接受调剂", "学号"};
        return excel.download(studentService.getStudents(), headers);


    }

}
