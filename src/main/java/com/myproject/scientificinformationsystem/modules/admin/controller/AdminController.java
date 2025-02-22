package com.myproject.scientificinformationsystem.modules.admin.controller;

import com.myproject.scientificinformationsystem.common.GemBeanUtils;
import com.myproject.scientificinformationsystem.common.SisResult;
import com.myproject.scientificinformationsystem.enums.ResultEnum;
import com.myproject.scientificinformationsystem.modules.admin.entity.Admin;
import com.myproject.scientificinformationsystem.modules.admin.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @ApiOperation(value = "更新",notes = "")
    @PostMapping("update")
    @ResponseBody
    SisResult update(Admin admin){
        Admin target = adminService.findAdminById(admin.getId());
        GemBeanUtils.copyProperties(admin,target);
        return adminService.updateAdmin(target) == true ? SisResult.ok() : SisResult.build(ResultEnum.FAIL);
    }

    @GetMapping("getName")
    @ResponseBody
    SisResult getName(Integer userId){
        Admin user = adminService.findAdminById(userId);
        Map<String,String> data=new HashMap<>();
        data.put("name",user.getName());
        return SisResult.build(200,"返回名字",data);
    }

    @GetMapping("getAccount")
    @ResponseBody
    SisResult getAccount(Integer userId){
        Admin user = adminService.findAdminById(userId);
        Map<String,String> data=new HashMap<>();
        data.put("account",user.getAccount());
        return SisResult.build(200,"返回账号",data);
    }
}
