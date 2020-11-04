package com.learning.demo.service;

import com.learning.demo.entity.Department;
import com.learning.demo.entity.Result;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments();

    Result updateDepartment(Department department);

    Result addDepartment(Department department);

    Result deleteDepartment(Integer departmentName);

    Result getDepartmentByName(String departmentName);
}
