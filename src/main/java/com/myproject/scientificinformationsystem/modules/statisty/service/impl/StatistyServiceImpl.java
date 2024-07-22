package com.myproject.scientificinformationsystem.modules.statisty.service.impl;

import com.myproject.scientificinformationsystem.modules.statisty.dao.StatistyDao;
import com.myproject.scientificinformationsystem.modules.statisty.service.StatistyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatistyServiceImpl implements StatistyService {

    @Autowired
    private StatistyDao statistyDao;

    @Override
    public int getProjectOne() {
        return statistyDao.getProjectOne();
    }

    @Override
    public int getProjectTwo() {
        return statistyDao.getProjectTwo();
    }

    @Override
    public int getProjectThree() {
        return statistyDao.getProjectThree();
    }

    @Override
    public int getProjectFour() {
        return statistyDao.getProjectFour();
    }

    @Override
    public int getProjectFive() {
        return statistyDao.getProjectFive();
    }

    @Override
    public int getProjectSix() {
        return statistyDao.getProjectSix();
    }
}
