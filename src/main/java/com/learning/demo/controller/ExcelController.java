package com.learning.demo.controller;

import com.learning.demo.service.ExcelService;
import com.learning.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@RequestMapping(value = "/excel")
public class ExcelController {
    @Autowired
    ExcelService excel;
    @Autowired
    StudentService studentService;
    @Value("${excel.dir}")
    String excelDir;

    @GetMapping(value = "/download")
    @ResponseBody
    public ResponseEntity download(HttpServletResponse response) throws IOException, FileNotFoundException {
        excel.download(studentService.getStudents());
        File file = new File(excelDir);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment;filename=\"%s", URLEncoder.encode("报名表.xlsx", "UTF-8")));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        ResponseEntity<Object> responseEntity = ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(resource);
        return responseEntity;
    }
}
