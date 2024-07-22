package com.myproject.scientificinformationsystem.modules.thesis.dao;

import com.myproject.scientificinformationsystem.modules.thesis.entity.Thesis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;


public interface ThesisDao extends JpaRepository<Thesis,Integer>, JpaSpecificationExecutor<Thesis> {
    @Query(value="select t.author as author, t.id as id, t.thesisname as thesisname, t.type as type, t.startTime as startTime, t.publication as publication, t.thesisabstract as thesisabstract, " +
            "t.passNum as passNum, " +
            "t.status as status, t.thesisPath as thesisPath " +
            " from Thesis t where t.thesisname like %?1%")
    Page<Map<String, Object>> findAllThesis(String name, Pageable pageable);

    @Query(value="select t.author as author, t.id as id, t.thesisname as thesisname, t.type as type, t.startTime as startTime, t.publication as publication, t.thesisabstract as thesisabstract, " +
            "t.passNum as passNum, " +
            "t.status as status, t.thesisPath as thesisPath " +
            " from Thesis t")
    Page<Map<String, Object>> findAllThesis(Pageable pageable);

    void deleteById(Integer id);

    Thesis getById(Integer id);

}
