package com.learning.demo.controller;

import com.learning.demo.entity.Department;
import com.learning.demo.entity.Result;
import com.learning.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping(value = "/getDepartments",produces = "application/json")
    List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @PostMapping(value = "/addDepartment")
    Result addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @PutMapping(value = "/updateDepartment")
    Result updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping(value = "/deleteDepartment")
    Result deleteDepartment(@RequestBody Integer departmentId){
        return departmentService.deleteDepartment(departmentId);
    }
}
