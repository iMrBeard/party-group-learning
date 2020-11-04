package com.learning.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Api("获取照片")
@Controller
@RequestMapping("/avatar")
public class FileController {
    @ApiOperation(value = "在查看单个报名表时获取照片", notes = "name对应在请求报名表时返回的学生信息中的avatar")
    @RequestMapping("/{name:.+}")
    public void getAvatar(@PathVariable("name") String name,
                          HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String imType = name.substring(name.lastIndexOf('.') + 1);
        response.setContentType("image/" + imType);
        try {
            FileInputStream fromServer = new FileInputStream(
                    new File("/home/hxq/" + name)
            );
            OutputStream toClient = response.getOutputStream();
            byte[] avatar = new byte[fromServer.available()];
            fromServer.read(avatar);
            toClient.write(avatar);
            toClient.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
