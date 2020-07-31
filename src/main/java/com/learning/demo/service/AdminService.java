package com.learning.demo.service;

import com.learning.demo.entity.Administrator;
import com.learning.demo.entity.Result;
import java.util.List;

public interface AdminService {

    Result addAdmin(Administrator administrator);

    Result deleteAdmin(String account);

    List<Administrator> getAdmins();
}
