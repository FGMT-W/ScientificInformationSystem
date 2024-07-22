package com.myproject.scientificinformationsystem.modules.thesispass.service.impl;

import com.myproject.scientificinformationsystem.modules.thesispass.dao.ThesispassDao;
import com.myproject.scientificinformationsystem.modules.thesispass.entity.Thesispass;
import com.myproject.scientificinformationsystem.modules.thesispass.service.ThesispassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThesispassServiceImpl implements ThesispassService {

    @Autowired
    private ThesispassDao thesispassDao;

    @Override
    public boolean addPass(Thesispass pass) {
        Thesispass save = thesispassDao.save(pass);
        return save != null ? true : false;
    }

    @Override
    public boolean existsPassByThesisIdAndAdminId(Integer thesisId, Integer adminId) {
        return thesispassDao.existsPassByThesisIdAndAdminId(thesisId, adminId);
    }

    @Override
    public int getCount(Integer thesisId) {
        return thesispassDao.getCount(thesisId);
    }

    @Override
    public int getPassCount(Integer thesisId) {
        return thesispassDao.getPassCount(thesisId);
    }
}
