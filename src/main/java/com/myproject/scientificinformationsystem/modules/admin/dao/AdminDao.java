package com.myproject.scientificinformationsystem.modules.admin.dao;

import com.myproject.scientificinformationsystem.modules.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminDao extends JpaRepository<Admin,Integer> {

    Admin findByAccount(String account);

    Admin findByAccountAndPassword(String account, String password);

}
