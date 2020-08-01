package com.learning.demo.service.Impl;

import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import com.learning.demo.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelServiceImpl implements ExcelService {
    public XSSFCellStyle setStyle(XSSFWorkbook workbook) {
        // 生成表格中非标题栏的样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.toHSSFColor());//背景色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成表格中非标题栏的字体
        XSSFFont font = workbook.createFont();
        //font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        // 把字体应用到当前的样式
        style.setFont(font);


        // 设置表格标题栏的样式
        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFillForegroundColor(IndexedColors.BLACK.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 设置标题栏字体
        XSSFFont titleFont = workbook.createFont();
        titleFont.setColor(HSSFColor.WHITE.index);
        titleFont.setFontHeightInPoints((short) 12);
        titleFont.setBold(true);
        // 把字体应用到当前的样式
        titleStyle.setFont(titleFont);
        return titleStyle;


    }

    @Override
    public XSSFWorkbook creatExcel(List<Student> studentInfo, String[] headers) {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet("报名表");
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        XSSFCellStyle titleStyle = setStyle(workbook);
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell;
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        for (short i = 0; i < headers.length; i++) {
            cell = row.createCell(i);
            cell.setCellStyle(titleStyle);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        // 遍历集合数据，产生数据行
        int k = 0;
        for (int i = 0; i < studentInfo.size(); i++) {
            Student student = studentInfo.get(i);
            if (student.getStudentId() != null) {
                XSSFRow content = sheet.createRow(k + 1);
                k++;
                cell = content.createCell(0);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getRealName());

                cell = content.createCell(1);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getGender());

                cell = content.createCell(2);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getClassName());

                cell = content.createCell(3);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getDepartmentName());

                cell = content.createCell(4);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getNation());

                cell = content.createCell(5);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getQqNumber());

                cell = content.createCell(6);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getEmail());

                cell = content.createCell(7);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getDescription());

                cell = content.createCell(8);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.isAdjustable());

                cell = content.createCell(9);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(student.getStudentId());
            }
        }

        return workbook;
    }

    @Override
    public Result download(List<Student> studentInfo, String[] headers) throws IOException {

        try {
            String localPath = "D:/报名表.xlsx";
            XSSFWorkbook xssfWorkbook = creatExcel(studentInfo, headers);
            //生成excel表
            FileOutputStream out = new FileOutputStream(localPath);

            xssfWorkbook.write(out);
            out.flush();
            out.flush();
            return Result.ofSuccess("成功导出");
        } catch (IOException e) {
            e.printStackTrace();
            return Result.ofFail("导出失败");
        }


    }
}
