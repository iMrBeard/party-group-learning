package com.learning.demo.service;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ExcelService {
    public XSSFWorkbook creatExcel(List<Student> studentInfo, String[] headers);

    public Result download(List<Student> studentInfo, String[] headers) throws IOException;
}
