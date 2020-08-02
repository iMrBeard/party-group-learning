package com.learning.demo.mapper;

import com.learning.demo.entity.Administrator;

import java.util.List;


public interface AdminMapper {

    List<Administrator> getAdmins();

    int addAdmin(Administrator administrator);

    int deleteAdmin(String account);

    Administrator isExistAdmin(String account);

}
