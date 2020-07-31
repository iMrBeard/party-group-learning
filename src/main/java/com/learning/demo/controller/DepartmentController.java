package com.learning.demo.controller;

import com.learning.demo.entity.Department;
import com.learning.demo.entity.Result;
import com.learning.demo.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
@Api(tags = "部门控制类")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @ApiOperation(value = "获取所有部门",produces = "application/json",httpMethod = "GET")
    @GetMapping(value = "/getDepartments",produces = "application/json")
    List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @ApiOperation(value = "添加部门",
            httpMethod = "POST",
            produces = "application/json",
            notes = "部门Id和剩余容量自动生成"
    )
    @PostMapping(value = "/addDepartment")
    Result addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @ApiOperation(value = "更新部门",httpMethod = "PUT",produces = "application/json")
    @PutMapping(value = "/updateDepartment")
    Result updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @ApiOperation(value = "删除部门",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteDepartment/{departmentId}")
    Result deleteDepartment(@PathVariable int departmentId){
        return departmentService.deleteDepartment(departmentId);
    }
}
