package com.myproject.scientificinformationsystem.modules.prize.service.impl;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.prize.service.PrizeService;
import com.myproject.scientificinformationsystem.modules.prize.dao.PrizeDao;
import com.myproject.scientificinformationsystem.modules.prize.entity.Prize;
import com.myproject.scientificinformationsystem.modules.prize.vo.PrizeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    private PrizeDao prizeDao;

    @Override
    public boolean addPrize(Prize prize) {
        Prize save = prizeDao.save(prize);
        return save != null ? true : false;
    }

    @Override
    public boolean deletePrizeById(Integer id) {
        prizeDao.deleteById(id);
        return true;
    }

    @Override
    public boolean updatePrize(Prize prize) {
        Prize save = prizeDao.save(prize);
        return save != null ? true : false;
    }

    @Override
    public Prize findPrizeByProjectId(Integer projectId) {
        return prizeDao.findByProjectId(projectId);
    }

    @Override
    public PageInfo findPageByParams(PrizeVo vo, Pageable pageable) {
        Page<Map<String,Object>> page;
        if(vo.getProjectName() == null || vo.getProjectName().isEmpty()){
            page = prizeDao.findAllPrize(pageable);
        }else{
            page = prizeDao.findAllPrize(vo.getProjectName(), pageable);
        }
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(page.getContent())
                .build();
        return pageInfo;
    }

    @Override
    public PageInfo findPageByUserParams(Integer userId, Pageable pageable) {
        Page<Map<String,Object>> page = prizeDao.findUserPrize(userId, pageable);
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(page.getContent())
                .build();
        return pageInfo;
    }
}
