package com.learning.demo.controller;

import com.learning.demo.entity.Administrator;
import com.learning.demo.entity.Department;
import com.learning.demo.entity.Result;
import com.learning.demo.mapper.DepartmentMapper;
import com.learning.demo.service.AdminService;
import com.learning.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/getAdmins",produces = "applications/json")
    List<Administrator> getAdmins(){
        return adminService.getAdmins();
    }

    @PostMapping(value = "/addAdmin")
    Result addAdmin(@RequestBody Administrator administrator){
        return adminService.addAdmin(administrator);
    }

    @DeleteMapping(value = "/deleteAdmin")
    Result deleteAdmin(@RequestBody String adminAccount){
        return adminService.deleteAdmin(adminAccount);
    }

}
