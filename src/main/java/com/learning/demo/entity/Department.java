package com.learning.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("部门")
public class Department {
    @ApiModelProperty("部门id")
    private Integer departmentId;

    @ApiModelProperty("部门名称")
    @NotBlank(message = "请填写部门名！")
    private String departmentName;

    @ApiModelProperty("部门描述")
    @NotBlank(message = "请输入部门描述！")
    private String description;

    @ApiModelProperty("部门剩余量")
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
