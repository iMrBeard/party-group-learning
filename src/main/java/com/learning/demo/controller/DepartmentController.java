package com.learning.demo.controller;

import com.learning.demo.entity.Department;
import com.learning.demo.entity.Result;
import com.learning.demo.service.DepartmentService;
import com.learning.demo.util.ErrorsToMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
@Api(tags = "部门控制类")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @ApiOperation(value = "获取所有部门", httpMethod = "GET")
    @GetMapping(value = "/getDepartments")
    List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @ApiOperation(value = "添加部门",
            httpMethod = "POST",
            produces = "application/json",
            notes = "部门Id和剩余容量自动生成"
    )
    @PostMapping(value = "/addDepartment")
    Result addDepartment(@Valid @RequestBody Department department, @ApiIgnore Errors errors) {
        if (errors.hasErrors()) {
            return Result.ofFail(ErrorsToMessage.getMessage(errors));
        } else {
            return departmentService.addDepartment(department);
        }
    }

    @ApiOperation(value = "更新部门", httpMethod = "PUT", produces = "application/json")
    @PutMapping(value = "/updateDepartment")
    Result updateDepartment(@Valid @RequestBody Department department, @ApiIgnore Errors errors) {
        if (errors.hasErrors()) {
            return Result.ofFail(ErrorsToMessage.getMessage(errors));
        }
        return departmentService.updateDepartment(department);
    }

    @ApiOperation(value = "删除部门", httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteDepartment")
    Result deleteDepartment(@RequestParam int departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }

    @ApiOperation(value = "通过部门名称获取部门信息", httpMethod = "POST")
    @PostMapping("/getDepartmentByName")
    Result getDepartmentByName(@RequestParam String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }
}
