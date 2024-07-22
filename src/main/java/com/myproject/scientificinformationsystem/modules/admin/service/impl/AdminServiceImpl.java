package com.myproject.scientificinformationsystem.modules.admin.service.impl;

import com.myproject.scientificinformationsystem.modules.admin.service.AdminService;
import com.myproject.scientificinformationsystem.modules.admin.dao.AdminDao;
import com.myproject.scientificinformationsystem.modules.admin.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean updateAdmin(Admin admin) {
        Admin save = adminDao.save(admin);
        if(save!=null){
            return true;
        }
        return false;
    }

    @Override
    public Admin findAdminById(Integer id) {
        Admin admin = adminDao.findById(id).get();
        return admin;
    }

    @Override
    public Admin findByAccount(String account) {
        return adminDao.findByAccount(account);
    }
}
