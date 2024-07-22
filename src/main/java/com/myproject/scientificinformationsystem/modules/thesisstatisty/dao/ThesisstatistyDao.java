package com.myproject.scientificinformationsystem.modules.thesisstatisty.dao;

import com.myproject.scientificinformationsystem.modules.thesis.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ThesisstatistyDao extends JpaRepository<Thesis,Integer>, JpaSpecificationExecutor<Thesis> {

    @Query(value="select count(p) from Thesis as p where type='EI'")
    int getProjectOne();

    @Query(value="select count(p) from Thesis as p where type='SCI'")
    int getProjectTwo();

    @Query(value="select count(p) from Thesis as p where type='TPSI'")
    int getProjectThree();

    @Query(value="select count(p) from Thesis as p where type='SCIE'")
    int getProjectFour();

    @Query(value="select count(p) from Thesis as p where type='核心'")
    int getProjectFive();

}
