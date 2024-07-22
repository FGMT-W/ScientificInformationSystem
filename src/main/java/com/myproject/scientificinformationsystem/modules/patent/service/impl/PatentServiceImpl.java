package com.myproject.scientificinformationsystem.modules.patent.service.impl;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.patent.dao.PatentDao;
import com.myproject.scientificinformationsystem.modules.patent.entity.Patent;
import com.myproject.scientificinformationsystem.modules.patent.service.PatentService;
import com.myproject.scientificinformationsystem.modules.patent.vo.PatentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PatentServiceImpl implements PatentService {

    @Autowired
    private PatentDao patentDao;

    @Override
    public boolean addPatent(Patent patent) {
        Patent save = patentDao.save(patent);
        return save != null ? true : false;
    }

    @Override
    public boolean deletePatentById(Integer id) {
        patentDao.deleteById(id);
        return true;
    }

    @Override
    public Patent findPatentByProjectId(Integer projectId) {
        return patentDao.findByProjectId(projectId);
    }

    @Override
    public PageInfo findPageByParams(PatentVo vo, Pageable pageable) {
        Page<Map<String,Object>> page;
        if(vo.getProjectName() == null || vo.getProjectName().isEmpty()){
            page = patentDao.findAllPatent(pageable);
        }else{
            page = patentDao.findAllPatent(vo.getProjectName(), pageable);
        }
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(page.getContent())
                .build();
        return pageInfo;
    }

    @Override
    public PageInfo findPageByUserParams(Integer userId, Pageable pageable) {
        Page<Map<String,Object>> page = patentDao.findUserPatent(userId, pageable);
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(page.getContent())
                .build();
        return pageInfo;
    }
}
