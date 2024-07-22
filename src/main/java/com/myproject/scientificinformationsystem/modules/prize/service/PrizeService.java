package com.myproject.scientificinformationsystem.modules.prize.service;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.prize.entity.Prize;
import com.myproject.scientificinformationsystem.modules.prize.vo.PrizeVo;
import org.springframework.data.domain.Pageable;

public interface PrizeService {

    boolean addPrize(Prize prize);

    boolean deletePrizeById(Integer id);

    boolean updatePrize(Prize prize);

    Prize findPrizeByProjectId(Integer projectId);

    PageInfo findPageByParams(PrizeVo vo, Pageable pageable);

    PageInfo findPageByUserParams(Integer userId, Pageable pageable);
}
