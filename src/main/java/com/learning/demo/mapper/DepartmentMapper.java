package com.learning.demo.mapper;

import com.learning.demo.entity.Department;
import java.util.List;

public interface DepartmentMapper {

    int addDepartment(Department department);

    int deleteDepartment(Integer departmentId);

    int updateDepartment(Department department);

    Department isExistDept(String departmentName);

    List<Department> getDepartments();
}