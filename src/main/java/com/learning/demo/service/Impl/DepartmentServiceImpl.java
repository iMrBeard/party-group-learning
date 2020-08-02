package com.learning.demo.service.Impl;

import com.learning.demo.entity.Department;
import com.learning.demo.entity.Result;
import com.learning.demo.entity.Student;
import com.learning.demo.mapper.DepartmentMapper;
import com.learning.demo.mapper.StudentMapper;
import com.learning.demo.service.DepartmentService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Department> getDepartments() {
        return departmentMapper.getDepartments();
    }

    @Override
    public Result updateDepartment(Department department) {
        int total = studentMapper.numberOfRegistered(department.getDepartmentName());
        department.setRemaining(department.getCapacity()-total);
        if(departmentMapper.updateDepartment(department) == 1)
            return Result.ofSuccess("部门更新成功！");
        else return Result.ofFail("部门更新失败！");
    }

    @Override
    public Result addDepartment(Department department) {
        Department department1 = departmentMapper.isExistDept("feidian");
        System.out.println(department1);
        if (departmentMapper.isExistDept(department.getDepartmentName()) != null) {
            return Result.ofFail("部门已经存在！");
        } else {
            department.setRemaining(department.getCapacity());
            if (departmentMapper.addDepartment(department) == 1)
                return Result.ofSuccess("部门添加成功！");
            else
                return Result.ofFail("部门添加失败");
        }
    }

    @Override
    public Result deleteDepartment(Integer departmentId) {
        if(departmentMapper.deleteDepartment(departmentId)==1)
            return Result.ofSuccess("删除部门成功！");
        else
            return Result.ofFail("删除部门失败！");
    }
}
