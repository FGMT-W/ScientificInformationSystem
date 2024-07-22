package com.myproject.scientificinformationsystem.modules.thesispass.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Thesispass")
public class Thesispass {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private Integer thesisId;
    private Integer adminId;
    private String result;

    public Thesispass(Integer thesisId, Integer adminId, String result){
        this.thesisId = thesisId;
        this.adminId = adminId;
        this.result = result;
    }

    public Thesispass(){

    }
}
