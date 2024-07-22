package com.myproject.scientificinformationsystem.modules.pass.service;

import com.myproject.scientificinformationsystem.modules.pass.entity.Pass;

public interface PassService {

    boolean addPass(Pass pass);

    boolean existsPassByProjectIdAndAdminId(Integer projectId, Integer adminId);

    int getCount(Integer projectId);

    int getPassCount(Integer projectId);

}
