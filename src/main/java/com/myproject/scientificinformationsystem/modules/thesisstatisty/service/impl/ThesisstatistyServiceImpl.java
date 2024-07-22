package com.myproject.scientificinformationsystem.modules.thesisstatisty.service.impl;

import com.myproject.scientificinformationsystem.modules.thesisstatisty.dao.ThesisstatistyDao;
import com.myproject.scientificinformationsystem.modules.thesisstatisty.service.ThesisstatistyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThesisstatistyServiceImpl implements ThesisstatistyService {

    @Autowired
    private ThesisstatistyDao thesisstatistyDao;

    @Override
    public int getProjectOne() {
        return thesisstatistyDao.getProjectOne();
    }

    @Override
    public int getProjectTwo() {
        return thesisstatistyDao.getProjectTwo();
    }

    @Override
    public int getProjectThree() {
        return thesisstatistyDao.getProjectThree();
    }

    @Override
    public int getProjectFour() {
        return thesisstatistyDao.getProjectFour();
    }

    @Override
    public int getProjectFive() {
        return thesisstatistyDao.getProjectFive();
    }

}
