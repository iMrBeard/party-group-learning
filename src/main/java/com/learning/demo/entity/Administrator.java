package com.learning.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Administrator {

    private String account;

    private String pwd;

    private String authority;

}
