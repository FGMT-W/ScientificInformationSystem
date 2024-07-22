package com.myproject.scientificinformationsystem.modules.patent.service;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.patent.entity.Patent;
import com.myproject.scientificinformationsystem.modules.patent.vo.PatentVo;
import org.springframework.data.domain.Pageable;

public interface PatentService {

    boolean addPatent(Patent patent);

    boolean deletePatentById(Integer id);

    Patent findPatentByProjectId(Integer projectId);

    PageInfo findPageByParams(PatentVo vo, Pageable pageable);

    PageInfo findPageByUserParams(Integer userId, Pageable pageable);
}
