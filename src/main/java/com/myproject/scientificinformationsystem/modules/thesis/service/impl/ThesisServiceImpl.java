package com.myproject.scientificinformationsystem.modules.thesis.service.impl;

import com.myproject.scientificinformationsystem.common.GemBeanUtils;
import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.thesis.dao.ThesisDao;
import com.myproject.scientificinformationsystem.modules.thesis.entity.Thesis;
import com.myproject.scientificinformationsystem.modules.thesis.vo.ThesisVo;
import com.myproject.scientificinformationsystem.modules.thesis.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ThesisServiceImpl implements ThesisService {

    @Autowired
    private ThesisDao thesisDao;

    @Override
    public Thesis findThesisById(Integer id) {
        Thesis thesis = thesisDao.findById(id).get();
        return thesis;
    }

    @Override
    public boolean addThesis(Thesis thesis) {
        Thesis save = thesisDao.save(thesis);
        return save != null ? true : false;
    }

    @Override
    public boolean deleteThesisById(Integer id) {
        thesisDao.deleteById(id);
        return true;
    }

    @Override
    public PageInfo findPageByParams(ThesisVo vo, Pageable pageable) {
        Thesis entity = new Thesis();
        GemBeanUtils.copyProperties(vo, entity);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true); //改变默认大小写忽略方式：忽略大小写
        Page<Thesis> page = thesisDao.findAll(Example.of(entity,matcher),pageable);
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(page.getContent())
                .build();
        return pageInfo;
    }

    @Override
    public PageInfo findThesisPageByParams(ThesisVo vo, Pageable pageable) {
        Page<Map<String,Object>> page;
        if(vo.getThesisname() == null || vo.getThesisname().isEmpty()){
            page = thesisDao.findAllThesis(pageable);
        }else{
            page = thesisDao.findAllThesis(vo.getThesisname(),pageable);
        }
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(page.getContent())
                .build();
        return pageInfo;
    }

    @Override
    public boolean updateThesis(Thesis thesis) {
        Thesis save = thesisDao.save(thesis);
        return save != null ? true : false;
    }

    @Override
    public List<Thesis> findAll() {
        List<Thesis> all = thesisDao.findAll();
        return all;
    }
}
