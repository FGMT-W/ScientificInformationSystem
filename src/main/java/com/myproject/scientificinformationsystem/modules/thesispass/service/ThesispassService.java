package com.myproject.scientificinformationsystem.modules.thesispass.service;

import com.myproject.scientificinformationsystem.modules.thesispass.entity.Thesispass;

public interface ThesispassService {

    boolean addPass(Thesispass pass);

    boolean existsPassByThesisIdAndAdminId(Integer thesisId, Integer adminId);

    int getCount(Integer thesisId);

    int getPassCount(Integer thesisId);

}
