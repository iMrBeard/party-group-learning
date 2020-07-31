package com.learning.demo.controller;

import com.learning.demo.entity.Administrator;
import com.learning.demo.entity.Result;
import com.learning.demo.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "管理员控制类")
public class AdminController {

    @Autowired
    AdminService adminService;

    @ApiOperation(value = "获取用户列表",notes = "返回json，成功返回true，失败返回false。",
            produces = "application/json",
            httpMethod = "GET"
    )
    @GetMapping(value = "/getAdmins",produces = "application/json")
    List<Administrator> getAdmins(){
        return adminService.getAdmins();
    }

    @ApiOperation(value = "增加管理员",
            produces = "application/json",
            httpMethod = "POST"
    )
    @PostMapping(value = "/addAdmin")
    Result addAdmin(@RequestBody Administrator administrator){
        return adminService.addAdmin(administrator);
    }

    @ApiOperation(value = "删除管理员",notes = "通过管理员账号删除管理员",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteAdmin/{account}")
    Result deleteAdmin(@PathVariable String adminAccount){
        return adminService.deleteAdmin(adminAccount);
    }

}
