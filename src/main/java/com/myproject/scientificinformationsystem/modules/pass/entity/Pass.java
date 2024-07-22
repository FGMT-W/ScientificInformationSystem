package com.myproject.scientificinformationsystem.modules.pass.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Pass")
public class Pass {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private Integer projectId;
    private Integer adminId;
    private String result;

    public Pass(Integer projectId, Integer adminId, String result){
        this.projectId = projectId;
        this.adminId = adminId;
        this.result = result;
    }

    public Pass(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
