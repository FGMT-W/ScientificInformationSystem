package com.myproject.scientificinformationsystem.modules.paper.service;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.paper.entity.Paper;
import com.myproject.scientificinformationsystem.modules.paper.vo.PaperVo;
import org.springframework.data.domain.Pageable;

public interface PaperService {

    boolean addPaper(Paper paper);

    boolean deletePaperById(Integer id);

    Paper findPaperByProjectId(Integer projectId);

    boolean updatePaper(Paper paper);

    PageInfo findPageByParams(PaperVo vo, Pageable pageable);

    PageInfo findPageByUserParams(Integer userId, Pageable pageable);
}
