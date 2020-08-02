package com.learning.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer departmentId;

    @NotBlank(message = "请填写部门名！")
    private String departmentName;

    @NotBlank(message = "请输入部门描述！")
    private String description;

    @NotNull
    private int remaining;
    private int capacity;

    public Department(String departmentName,String description, int remaining, int capacity) {
        this.departmentName = departmentName;
        this.description = description;
        this.remaining = remaining;
        this.capacity = capacity;
    }
}
