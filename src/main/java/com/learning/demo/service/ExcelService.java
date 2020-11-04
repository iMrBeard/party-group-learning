package com.learning.demo.service;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public interface ExcelService {
    XSSFWorkbook creatExcel(List<Student> studentInfo, String[] headers);

    Result download(List<Student> studentInfo) throws IOException;
}
