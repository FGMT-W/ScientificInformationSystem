package com.myproject.scientificinformationsystem.modules.thesispass.dao;

import com.myproject.scientificinformationsystem.modules.thesispass.entity.Thesispass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThesispassDao extends JpaRepository<Thesispass, Integer> {

    boolean existsPassByThesisIdAndAdminId(Integer thesisId, Integer adminId);

    @Query(value="select count(p) from Thesispass as p where thesis_id=?1")
    int getCount(Integer thesisId);

    @Query(value="select count(p) from Thesispass as p where thesis_id=?1 and result='通过'")
    int getPassCount(Integer thesisId);
}
