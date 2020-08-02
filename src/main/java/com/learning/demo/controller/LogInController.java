package com.learning.demo.controller;

import com.learning.demo.entity.Administrator;
import com.learning.demo.entity.Result;
import com.learning.demo.mapper.AdminMapper;
import com.learning.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/log")
public class LogInController {
    @Autowired
    AdminMapper adminMapper;

    @PostMapping(value = "/logIn")
    public Result logIn(@RequestBody Map<String, String> admin) {
        Administrator admin1 = adminMapper.isExistAdmin(admin.get("account"));
        if (admin1 == null)
            return Result.ofFail("不存在账号");
        else if (admin.get("password").equals(admin1.getPwd()))
            return Result.ofSuccess("登录成功");
        else return Result.ofFail("密码错误");
    }
}
