package com.myproject.scientificinformationsystem.modules.pass.dao;

import com.myproject.scientificinformationsystem.modules.pass.entity.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PassDao extends JpaRepository<Pass, Integer> {

    boolean existsPassByProjectIdAndAdminId(Integer projectId, Integer adminId);

    @Query(value="select count(p) from Pass as p where project_id=?1")
    int getCount(Integer projectId);

    @Query(value="select count(p) from Pass as p where project_id=?1 and result='通过'")
    int getPassCount(Integer projectId);
}
