package com.learning.demo.service.Impl;

import com.learning.demo.entity.Administrator;
import com.learning.demo.entity.Result;
import com.learning.demo.mapper.AdminMapper;
import com.learning.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Result addAdmin(Administrator administrator) {
        if(adminMapper.isExistAdmin(administrator.getAccount())!=null)
            return Result.ofFail("管理员已经存在");
        if(adminMapper.addAdmin(administrator) == 1)
            return Result.ofSuccess("添加管理员成功！");
        else
            return Result.ofFail("添加管理员失败！");
    }

    @Override
    public Result deleteAdmin(String account) {
        if(adminMapper.deleteAdmin(account) == 1)
            return Result.ofSuccess("删除管理员成功！");
        else
            return Result.ofFail("删除管理员失败");
    }

    @Override
    public List<Administrator> getAdmins() {
        return adminMapper.getAdmins();
    }
}
