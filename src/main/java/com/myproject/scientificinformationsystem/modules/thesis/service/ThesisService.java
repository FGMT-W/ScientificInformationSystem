package com.myproject.scientificinformationsystem.modules.thesis.service;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.thesis.entity.Thesis;
import com.myproject.scientificinformationsystem.modules.thesis.vo.ThesisVo;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ThesisService {

    boolean addThesis(Thesis project);

    boolean deleteThesisById(Integer id);

    boolean updateThesis(Thesis thesis);

    List<Thesis> findAll();

    Thesis findThesisById(Integer id);

    PageInfo findPageByParams(ThesisVo vo, Pageable pageable);

    PageInfo findThesisPageByParams(ThesisVo vo, Pageable pageable);

}
