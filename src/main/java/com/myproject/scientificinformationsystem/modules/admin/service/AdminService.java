package com.myproject.scientificinformationsystem.modules.admin.service;

import com.myproject.scientificinformationsystem.modules.admin.entity.Admin;

public interface AdminService {

    boolean updateAdmin(Admin admin);

    Admin findByAccount(String account);

    Admin findAdminById(Integer id);

}
